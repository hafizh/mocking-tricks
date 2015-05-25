package de.testing.services;

import de.testing.dtos.CountryDto;

/**
 * Created by hhasanov on 25/05/15.
 */
public interface CountryService {

    public CountryDto getCountryByCode(String countryCode);

    public CountryDto getCountryByName(String countryName);
}
