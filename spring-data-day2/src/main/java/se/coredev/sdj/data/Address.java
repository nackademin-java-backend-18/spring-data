package se.coredev.sdj.data;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String postal;
    private String zip;

    protected Address() {
    }

    public Address(String street, String postal, String zip) {
        this.street = street;
        this.postal = postal;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getPostal() {
        return postal;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", street, postal, zip);
    }
}
