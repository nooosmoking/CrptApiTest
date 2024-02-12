package org.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) {
        CrptApi api = new CrptApi(TimeUnit.MINUTES, 2);

        Document document = createTestDocument();
        while (true){
            api.createDocument(document, "111");
        }
    }

    private static Document createTestDocument(){
        Description description = new Description("string");
        Product product = new Product("certificateDocument", new Date(), "certificateDocumentNumber", "ownerInn",
                "producerInn", new Date(), "tnvedCode", "uitCode", "uituCode");
        List<Product> products = List.of(product);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2020-01-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Document(description, "doc_id", "doc_status", "LP_INTRODUCE_GOODS",
                true, "owner_inn", "participant_inn", "producer_inn", date, "production_type",
                products, date, "reg_number");
    }
}
