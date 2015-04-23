package com.hongkailiu.test.app.graph;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Vertex {
    private String label;
    private boolean isVisted = false;

    public Vertex(String label) {
        super();
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisted() {
        return isVisted;
    }

    public void setVisted(boolean isVisted) {
        this.isVisted = isVisted;
    }

    @Override public int hashCode() {
        return new HashCodeBuilder().append(label).toHashCode();
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
        Vertex other = (Vertex) obj;
        return new EqualsBuilder()
            //.appendSuper(super.equals(obj))
            .append(label, other.label).isEquals();
    }

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
