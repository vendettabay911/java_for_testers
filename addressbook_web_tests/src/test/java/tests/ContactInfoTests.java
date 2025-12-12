package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones() {
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(contact -> contact.id(), contact ->
                Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.contact().getPhones();
        Assertions.assertEquals(expected, phones);
    }

    @Test
    void testEmails() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
    }

    @Test
    void testContactData() {
        var contacts = app.contact().getList();
        var dataFromHomePage = contacts.get(0);
        var dataFromEditPage = app.contact().getContactFormData(dataFromHomePage);
        var first = contacts.stream().collect(Collectors.toMap(contact -> contact.id(), contact ->
                Stream.of(contact.phone(), contact.address(), contact.email())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        Map<String, String> contactMap = new HashMap<>();
        String phoneNumbers = Stream.of(dataFromEditPage.home(),
                        dataFromEditPage.mobile(),
                        dataFromEditPage.work(),
                        dataFromEditPage.secondary(),
                        dataFromEditPage.address(),
                        dataFromEditPage.email(),
                        dataFromEditPage.email2(),
                        dataFromEditPage.email3())
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining("\n"));
        contactMap.put(dataFromEditPage.id(), phoneNumbers);
        Assertions.assertEquals(first.get(dataFromEditPage.id()), contactMap.get(dataFromHomePage.id()));
    }
}