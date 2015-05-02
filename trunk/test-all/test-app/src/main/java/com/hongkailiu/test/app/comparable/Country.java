package com.hongkailiu.test.app.comparable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override public int hashCode() {
        return new HashCodeBuilder().append(countryId).toHashCode();
    }

    @Override public boolean equals(final Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Country other = (Country) obj;
        return new EqualsBuilder()
            //.appendSuper(super.equals(obj))
            .append(countryId, other.countryId).isEquals();
    }
}
