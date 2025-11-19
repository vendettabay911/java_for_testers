package model;

public record ContactData(String id, String first_name, String last_name, String phone) {
    public ContactData() {
        this ("", "", "", "");
    }

    public ContactData withContactId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.phone);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.phone);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.phone);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.first_name, this.last_name, phone);
    }
}