package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void createContact(ContactData contact, GroupData group) {
        openContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void selectGroupWithContacts(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroupWithContacts(group);
        removeSelectedContactFromGroup(contact);
        openHomePage();
    }

    private void removeSelectedContactFromGroup(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
        click(By.name("remove"));
    }


    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContactEdit(contact);
        fillContactForm(modifiedContact);
        submitContactEdit();
        returnToHomePage();
    }

    public void submitContactEdit() {
        click(By.name("update"));
    }

    private void selectContactEdit(ContactData contact) {
        click(By.cssSelector(String.format("a[href^='edit.php?id=%s']", contact.id())));
        //click(By.cssSelector(String.format("input[value='%s']",contact.id())));
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }



    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name());
        type(By.name("lastname"), contact.last_name());
        type(By.name("mobile"), contact.phone());
        attach(By.name("photo"), contact.photo());
    }

    private void openHomePage() {
        if (!manager.isElementPresent((By.name("new")))) {
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCountContact() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    private void openContactPage() {
        if (!manager.isElementPresent((By.name("nickname")))) {
            click(By.linkText("add new"));
        }
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.name("entry"));
        for (var td : tds) {
            //var name = td.getText();
            var tdFirstName = td.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var tdLastName = td.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var tdPhone = td.findElement(By.cssSelector("td:nth-child(6)")).getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withContactId(id).withFirstName(tdFirstName).withLastName(tdLastName).withPhone(tdPhone));
        }
        return contacts;
    }
}