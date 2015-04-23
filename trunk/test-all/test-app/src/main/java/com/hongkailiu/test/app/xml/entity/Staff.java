package com.hongkailiu.test.app.xml.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * ref.
 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
 * http://stackoverflow.com/questions/5038204/apache-commons-equals-hashcode-builder
 *
 * @author Liu
 */
public class Staff {

    private int id;
    private String firstname;
    private String lastname;
    private String nickname;
    private float salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override public int hashCode() {
        return new HashCodeBuilder().append(id).append(firstname).append(lastname).append(nickname)
            .append(salary).toHashCode();
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
        Staff other = (Staff) obj;
        return new EqualsBuilder()
            //.appendSuper(super.equals(obj))
            .append(id, other.id).append(firstname, other.firstname)
            .append(lastname, other.lastname).append(nickname, other.nickname)
            .append(salary, other.salary).isEquals();
    }

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	/*
	<company>
	<staff id="1001">
		<firstname>yong</firstname>
		<lastname>mook kim</lastname>
		<nickname>mkyong</nickname>
		<salary>100000</salary>
	</staff>
	<staff id="2001">
		<firstname>low</firstname>
		<lastname>yin fong</lastname>
		<nickname>fong fong</nickname>
		<salary>200000</salary>
	</staff>
</company>
*/
}
