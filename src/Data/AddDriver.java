package Data;

public class AddDriver {
    private String name;
    private String nIC;
    private String license;
    private String contact;
    private String address;

    public AddDriver() {
    }

    public AddDriver(String name, String nIC, String license, String contact, String address) {
        this.setName(name);
        this.setnIC(nIC);
        this.setLicense(license);
        this.setContact(contact);
        this.setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getnIC() {
        return nIC;
    }

    public void setnIC(String nIC) {
        this.nIC = nIC;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
