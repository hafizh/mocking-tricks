package de.testing.services;

import de.testing.dtos.Country;

/**
 * Created by hhasanov on 25/05/15.
 */
public interface CountryService {

    public Country getCountryByCode(String countryCode);

    public Country getCountryByName(String countryName);
}
