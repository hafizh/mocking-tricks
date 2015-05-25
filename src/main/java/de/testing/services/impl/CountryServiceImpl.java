package de.testing.services.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import de.testing.dtos.Country;
import de.testing.services.CountryService;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.google.common.base.Optional.fromNullable;
import static java.util.Locale.*;

/**
 * Created by hhasanov on 25/05/15.
 */
public class CountryServiceImpl implements CountryService {

    private static final Map<String, Country> COUNTRIES_BY_CODE;
    private static final Map<String, Country> COUNTRIES_BY_NAME;
    private static final Country DEFAULT = new Country(GERMANY.getCountry(), "Germany", GERMANY);
    private static final List<Country> COUNTRIES = ImmutableList.of(
            DEFAULT,
            new Country(CHINA.getCountry(), "China", CHINA),
            new Country(US.getCountry(), "USA", US),
            new Country(ITALY.getCountry(), "Italy", ITALY),
            new Country(JAPAN.getCountry(), "Japan", JAPAN)
    );

    static {
        final ImmutableMap.Builder<String, Country> countriesByCode = ImmutableMap.builder();
        final ImmutableMap.Builder<String, Country> countriesByName = ImmutableMap.builder();

        for (Country country : COUNTRIES) {
            countriesByCode.put(country.getCode(), country);
            countriesByName.put(country.getName(), country);
        }

        COUNTRIES_BY_CODE = countriesByCode.build();
        COUNTRIES_BY_NAME = countriesByName.build();
    }

    @Override
    public Country getCountryByCode(String countryCode) {
        Country nullableReference = COUNTRIES_BY_CODE.get(countryCode);
        return fromNullable(nullableReference)
                .or(DEFAULT);
    }

    @Override
    public Country getCountryByName(String countryName) {
        Country nullableReference = COUNTRIES_BY_NAME.get(countryName);
        return fromNullable(nullableReference)
                .or(DEFAULT);
    }
}
