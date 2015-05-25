package de.testing.services.impl;

import de.testing.dtos.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static java.util.Locale.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountryServiceImplTest {

    private static final Country GERMANY = new Country("DE", "Germany", Locale.GERMANY);
    private CountryServiceImpl countryService = new CountryServiceImpl();

    @Parameter
    public String inputCode;
    @Parameter(1)
    public String inputName;
    @Parameter(2)
    public Country expected;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"IT", "Italy", new Country("IT", "Italy", ITALY)},
                {"DE", "Germany", GERMANY},
                {"de", "Germany", GERMANY},
                {"FR", "France", GERMANY},
                {"US", "USA", new Country("US", "USA", US)},
                {"CN", "China", new Country("CN", "China", CHINA)},
                {"JP", "Japan", new Country("JP", "Japan", JAPAN)}
        });
    }

    @Test
    public void getCountryByCode() {
        assertThat(countryService.getCountryByCode(inputCode), equalTo(expected));
    }

    @Test
    public void getCountryByName() {
        assertThat(countryService.getCountryByName(inputName), equalTo(expected));
    }
}