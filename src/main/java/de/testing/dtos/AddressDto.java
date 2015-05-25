package de.testing.dtos;

/**
 * Created by hhasanov on 25/05/15.
 */
public class AddressDto {

    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String countryName;

    public AddressDto(final String street, final String number, final String zipCode, final String city, final String countryName) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.countryName = countryName;
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

    public String getCountryName() {
        return countryName;
    }
}
