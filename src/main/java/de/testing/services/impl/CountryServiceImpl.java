package de.testing.services.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import de.testing.dtos.CountryDto;
import de.testing.services.CountryService;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Optional.fromNullable;
import static java.util.Locale.*;

/**
 * Created by hhasanov on 25/05/15.
 */
public class CountryServiceImpl implements CountryService {

    private static final Map<String, CountryDto> COUNTRIES_BY_CODE;
    private static final Map<String, CountryDto> COUNTRIES_BY_NAME;
    private static final CountryDto DEFAULT = new CountryDto(GERMANY.getCountry(), "Germany", GERMANY);
    private static final List<CountryDto> COUNTRIES = ImmutableList.of(
            DEFAULT,
            new CountryDto(CHINA.getCountry(), "China", CHINA),
            new CountryDto(US.getCountry(), "USA", US),
            new CountryDto(ITALY.getCountry(), "Italy", ITALY),
            new CountryDto(JAPAN.getCountry(), "Japan", JAPAN)
    );

    static {
        final ImmutableMap.Builder<String, CountryDto> countriesByCode = ImmutableMap.builder();
        final ImmutableMap.Builder<String, CountryDto> countriesByName = ImmutableMap.builder();

        for (CountryDto country : COUNTRIES) {
            countriesByCode.put(country.getCode(), country);
            countriesByName.put(country.getName(), country);
        }

        COUNTRIES_BY_CODE = countriesByCode.build();
        COUNTRIES_BY_NAME = countriesByName.build();
    }

    @Override
    public CountryDto getCountryByCode(String countryCode) {
        CountryDto nullableReference = COUNTRIES_BY_CODE.get(countryCode);
        return fromNullable(nullableReference)
                .or(DEFAULT);
    }

    @Override
    public CountryDto getCountryByName(String countryName) {
        CountryDto nullableReference = COUNTRIES_BY_NAME.get(countryName);
        return fromNullable(nullableReference)
                .or(DEFAULT);
    }
}
