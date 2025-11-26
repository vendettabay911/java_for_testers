package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static common.CommonFunctions.randomString;


public class ContactCreationTests extends TestBase{


    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>(List.of());
//        for (var first_name : List.of("","first name")) {
//            for (var last_name : List.of("", "last name")) {
//                for (var phone : List.of("", "phone")) {
//                    result.add(new ContactData().withFirstName(first_name).withLastName(last_name).withPhone(phone));
//                }
//            }
//        }
        var json = "";
        try (var reader = new FileReader("contacts.json");
             var breader = new BufferedReader(reader)
        ) {
            var line = breader.readLine();
            while(line != null) {
                json = json + line;
                line = breader.readLine();
            }
        }
        //var json = Files.readString(Paths.get("groups.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contact().getList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withContactId(newContacts.get(newContacts.size()-1).id()).withPhone("").withLastName("").withFirstName(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }


    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstName(randomString(10))
                .withLastName(randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contact().createContact(contact);
    }
}