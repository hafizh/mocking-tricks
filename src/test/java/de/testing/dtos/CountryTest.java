package de.testing.dtos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static java.util.Locale.GERMANY;
import static java.util.Locale.ITALY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountryTest {

    public static final Country ITALY = new Country("IT", "Italy", Locale.ITALY);
    @Parameterized.Parameter
    public Country c1;
    @Parameterized.Parameter(1)
    public Country c2;
    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {ITALY, new Country("DE", "Germany", GERMANY), false},
                {ITALY, new Country("IT", "Italy", Locale.ITALY), true},
                {ITALY, new Country("IT", "Germany", Locale.ITALY), false},
                {ITALY, new Country("IT", "Italy", GERMANY), false},
                {ITALY, new Country("DE", "Italy", Locale.ITALY), false},
                {ITALY, null, false}
        });
    }

    @Test
    public void testEquals() {
        assertThat(c1.equals(c2), is(expected));
    }
}