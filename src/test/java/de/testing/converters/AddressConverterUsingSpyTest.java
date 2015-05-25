package de.testing.converters;

import de.testing.domain.Address;
import de.testing.dtos.AddressDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressConverterUsingSpyTest {

    private static final String TEST_STREET = "test street";
    private static final String TEST_NUMBER = "test number";
    private static final String TEST_ZIP_CODE = "test zip code";
    private static final String TEST_CITY = "Berlin";
    private static final String TEST_CODE = "DE";
    private static final String TEST_NAME = "Germany";

    @Spy
    private AddressConverter addressConverterSpy;

    @Before
    public void setUp() {
        doReturn("DE").when(addressConverterSpy).getCountryCode(anyString());
        doReturn("Germany").when(addressConverterSpy).getCountryName(anyString());
    }

    @Test
    public void doForward() {
        Address address = new Address(TEST_STREET, TEST_NUMBER, TEST_ZIP_CODE, TEST_CITY, TEST_CODE);
        final AddressDto dto = addressConverterSpy.doForward(address);
        assertThat(dto.getStreet(), is(TEST_STREET));
        assertThat(dto.getNumber(), is(TEST_NUMBER));
        assertThat(dto.getZipCode(), is(TEST_ZIP_CODE));
        assertThat(dto.getCity(), is(TEST_CITY));
        assertThat(dto.getCountryName(), is(TEST_NAME));
    }

    @Test
    public void doBackward() {
        AddressDto dto = new AddressDto(TEST_STREET, TEST_NUMBER, TEST_ZIP_CODE, TEST_CITY, TEST_NAME);
        final Address address = addressConverterSpy.doBackward(dto);
        assertThat(address.getStreet(), is(TEST_STREET));
        assertThat(address.getNumber(), is(TEST_NUMBER));
        assertThat(address.getZipCode(), is(TEST_ZIP_CODE));
        assertThat(address.getCity(), is(TEST_CITY));
        assertThat(address.getCountryCode(), is(TEST_CODE));
    }
}