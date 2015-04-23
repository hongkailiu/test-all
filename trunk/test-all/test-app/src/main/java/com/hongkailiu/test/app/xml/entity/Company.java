package com.hongkailiu.test.app.xml.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;

public class Company {

    private Set<Staff> staffSet;

    public Set<Staff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<Staff> staffSet) {
        this.staffSet = staffSet;
    }

    //	@Override
    //	public int hashCode(){
    //	    return HashCodeBuilder.reflectionHashCode(this);
    //	}
    //
    //	@Override
    //	public boolean equals(final Object obj){
    //		return EqualsBuilder.reflectionEquals(this, obj);
    //	}

    @Override public int hashCode() {
        return new HashCodeBuilder().append(staffSet).toHashCode();
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
        Company other = (Company) obj;
        return new EqualsBuilder()
            //.appendSuper(super.equals(obj))
            .append(staffSet, other.staffSet).isEquals();
    }

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
