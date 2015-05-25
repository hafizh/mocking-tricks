package de.testing.converters;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Converter;
import de.testing.domain.Address;
import de.testing.dtos.AddressDto;
import de.testing.services.CountryService;

/**
 * Created by hhasanov on 25/05/15.
 */
public class AddressConverter extends Converter<Address, AddressDto> {

    private CountryService countryService;

    public void setCountryService(final CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    protected AddressDto doForward(Address address) {
        return new AddressDto(
                address.getStreet(),
                address.getNumber(),
                address.getZipCode(),
                address.getCity(),
                getCountryName(address.getCountryCode())
        );
    }

    @Override
    protected Address doBackward(AddressDto dto) {
        return new Address(
                dto.getStreet(),
                dto.getNumber(),
                dto.getZipCode(),
                dto.getCity(),
                getCountryCode(dto.getCountryName())
        );
    }

    @VisibleForTesting
    String getCountryCode(String name) {
        return countryService.getCountryByName(name).getCode();
    }

    @VisibleForTesting
    String getCountryName(String code) {
        return countryService.getCountryByCode(code).getName();
    }
}
