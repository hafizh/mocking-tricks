package de.testing.services.impl;

import de.testing.dtos.CountryDto;
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

    private static final CountryDto GERMANY = new CountryDto("DE", "Germany", Locale.GERMANY);
    private CountryServiceImpl countryService = new CountryServiceImpl();

    @Parameter
    public String inputCode;
    @Parameter(1)
    public String inputName;
    @Parameter(2)
    public CountryDto expected;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"IT", "Italy", new CountryDto("IT", "Italy", ITALY)},
                {"DE", "Germany", GERMANY},
                {"de", "Germany", GERMANY},
                {"FR", "France", GERMANY},
                {"US", "USA", new CountryDto("US", "USA", US)},
                {"CN", "China", new CountryDto("CN", "China", CHINA)},
                {"JP", "Japan", new CountryDto("JP", "Japan", JAPAN)}
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