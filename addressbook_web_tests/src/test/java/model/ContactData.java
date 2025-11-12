package model;

public record ContactData(String first_name, String last_name, String phone) {
    public ContactData() {
        this ("", "", "");
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(first_name, this.last_name, this.phone);
    }

    public ContactData withHeader(String last_name) {
        return new ContactData(this.first_name, last_name, this.phone);
    }

    public ContactData withFooter(String phone) {
        return new ContactData(this.first_name, this.last_name, phone);
    }
}