package com.hongkailiu.test.app.xml.entity;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Company {

	private Set<Staff> staffSet;

	public Set<Staff> getStaffSet() {
		return staffSet;
	}

	public void setStaffSet(Set<Staff> staffSet) {
		this.staffSet = staffSet;
	}
	
	@Override
	public int hashCode(){
	    return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(final Object obj){
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}