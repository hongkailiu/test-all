package com.hongkailiu.test.app.comparable;

/**
 * ref. http://www.javacodegeeks.com/2013/03/difference-between-comparator-and-comparable-in-java.html
 *
 * @author Liu
 */
public class Country implements Comparable<Country> {
    private int countryId;

    public Country(int countryId) {
        super();
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    @Override public int compareTo(Country arg0) {
        Country country = (Country) arg0;
        return (this.countryId < country.countryId) ?
            -1 :
            (this.countryId > country.countryId) ? 1 : 0;
    }
}
