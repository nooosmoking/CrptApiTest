package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CrptApi {
        TimeUnit timeUnit;
        Semaphore semaphore;
        int requestLimit;
        public CrptApi(TimeUnit timeUnit, int requestLimit){
            this.timeUnit = timeUnit;
            this.semaphore = new Semaphore(0);
            this.requestLimit = requestLimit;

            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                               @Override
                               public void run() {
                                   semaphore.release(requestLimit - semaphore.availablePermits());
                               }},
                    0, timeUnit.toMillis(1));
        }

        public void createDocument(Document document, String signature){
            try{
                semaphore.acquire();
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Irkutsk"));
                String jsonDocument = objectMapper.writeValueAsString(document);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://127.0.0.1:8000"))
                        .header("Content-Type", "application/json")
                        .header("Authorization", "HMAC-SHA256 " + signHash(jsonDocument, signature))
                        .POST(HttpRequest.BodyPublishers.ofString(jsonDocument))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (InterruptedException | IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

        private String signHash(String jsonDoc, String signature){
            String secretKey = "your_secret_key";

            try {
                Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
                SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
                sha256_HMAC.init(secret_key);

                String data = jsonDoc + signature;
                byte[] hash = sha256_HMAC.doFinal(data.getBytes());

                return Base64.getEncoder().encodeToString(hash);
            } catch (NoSuchAlgorithmException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        }
    }

