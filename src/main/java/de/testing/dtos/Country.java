package de.testing.dtos;

import java.util.Locale;

/**
 * Created by hhasanov on 25/05/15.
 */
public class Country {

    private final String code;
    private final String name;
    private final Locale locale;

    public Country(String code, String name, Locale locale) {
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
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        boolean b = code.equals(country.code) && locale.equals(country.locale) && name.equals(country.name);
        return b;
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + locale.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", locale=" + locale +
                '}';
    }
}
