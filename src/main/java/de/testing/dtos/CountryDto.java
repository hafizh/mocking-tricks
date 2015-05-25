package de.testing.dtos;

import com.google.common.base.MoreObjects;

import java.util.Locale;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Created by hhasanov on 25/05/15.
 */
public class CountryDto {

    private final String code;
    private final String name;
    private final Locale locale;

    public CountryDto(String code, String name, Locale locale) {
        this.code = code;
        this.name = name;
        this.locale = locale;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Locale getLocale() {
        return locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryDto)) return false;

        CountryDto country = (CountryDto) o;

        return Objects.equals(code, country.getCode()) &&
                Objects.equals(name, country.getName()) &&
                Objects.equals(locale, country.getLocale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, locale);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("code", code)
                .add("name", name)
                .add("locale", locale)
                .toString();
    }
}
