package de.testing.domain;

/**
 * Created by hhasanov on 25/05/15.
 */
public class Address {

    private final String street;
    private final String number;
    private final String zipCode;
    private final String city;
    private final String countryCode;

    public Address(final String street, final String number, final String zipCode, final String city, final String countryCode) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.countryCode = countryCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
