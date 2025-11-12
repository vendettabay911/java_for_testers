package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactCreationTests extends TestBase{

    @Test
    void canCreateContact() {
        app.contact().createContact(new ContactData().withFirstName("Test"));
    }
}