import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    @Test
    public void testCreateDocument() {
        CrptApi api = new CrptApi(TimeUnit.MINUTES, 2);

        CrptApi.Document document = createTestDocument();

        api.createDocument(document, "111");

        assertEquals(1, api.semaphore.availablePermits(), "Semaphore should have 2 available permits");
    }

    private CrptApi.Document createTestDocument() {
        CrptApi.Document.Description description = new CrptApi.Document.Description("Test description");
        CrptApi.Document.Product product = new CrptApi.Document.Product("Test product", new Date(), "123", "456",
                "789", new Date(), "code1", "code2", "code3");
        List<CrptApi.Document.Product> products = List.of(product);
        Date date = new Date();
        return new CrptApi.Document(description, "doc_id", "doc_status", "type",
                true, "owner_inn", "participant_inn", "producer_inn", date, "production_type",
                products, date, "reg_number");
    }
}
