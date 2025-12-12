package model;

public record ContactData(String id, String first_name, String last_name, String phone, String photo, String home,
                          String mobile,
                          String work,
                          String secondary,
                          String address,
                          String email,
                          String email2,
                          String email3) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withContactId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, this.work, this.secondary, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, this.work, this.secondary, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.phone, this.photo, this.home, this.mobile, this.work, this.secondary, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.first_name, this.last_name, phone, this.photo, this.home, this.mobile, this.work, this.secondary, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, photo, this.home, this.mobile, this.work, this.secondary, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, home, this.mobile, this.work, this.secondary, this.address, this.email, this.email2, this.email3);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, this.home, mobile, this.work, this.secondary, this.address, this.email, this.email2, this.email3);

    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, work, this.secondary, this.address, this.email, this.email2, this.email3);

    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, this.work, secondary, this.address, this.email, this.email2, this.email3);

    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, this.work, this.secondary, address, this.email, this.email2, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, this.work, this.secondary, this.address, email, this.email2, this.email3);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, this.work, this.secondary, this.address, this.email, email2, this.email3);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.first_name, this.last_name, this.phone, this.photo, this.home, this.mobile, this.work, this.secondary, this.address, this.email, this.email2, email3);
    }

}

