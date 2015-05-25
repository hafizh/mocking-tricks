package de.testing.dtos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static java.util.Locale.GERMANY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountryDtoTest {

    public static final CountryDto ITALY = new CountryDto("IT", "Italy", Locale.ITALY);
    @Parameterized.Parameter
    public CountryDto c1;
    @Parameterized.Parameter(1)
    public CountryDto c2;
    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {ITALY, new CountryDto("DE", "Germany", GERMANY), false},
                {ITALY, new CountryDto("IT", "Italy", Locale.ITALY), true},
                {ITALY, new CountryDto("IT", "Germany", Locale.ITALY), false},
                {ITALY, new CountryDto("IT", "Italy", GERMANY), false},
                {ITALY, new CountryDto("DE", "Italy", Locale.ITALY), false},
                {ITALY, null, false}
        });
    }

    @Test
    public void testEquals() {
        assertThat(c1.equals(c2), is(expected));

        if(c2 != null) {
            assertThat(c2.equals(c1), is(expected));
        }
    }
}