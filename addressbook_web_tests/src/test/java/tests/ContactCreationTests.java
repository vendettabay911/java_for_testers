package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase{

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of());
        for (var first_name : List.of("","first name")) {
            for (var last_name : List.of("", "last name")) {
                for (var phone : List.of("", "phone")) {
                    result.add(new ContactData(first_name, last_name, phone));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i * 10),randomString(i * 10),randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contact().getCountContact();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getCountContact();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }


    @Test
    void canCreateContact() {
        app.contact().createContact(new ContactData().withFirstName("Test"));
    }
}