package com.hongkailiu.test.app.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		// StringBuilder sb = new StringBuilder();

		// if (certificates!=null) {
		// sb.append("[");
		// for (Certificate c : certificates) {
		// sb.append(c + ",");
		// }
		// sb.append("]");
		// } else {
		// sb.append("null");
		// }
		// return
		// "id="+id+", name="+name+", country="+country+", certificates="+sb.toString();
		return "id=" + id + ", name=" + name + ", country=" + country;
	}

	public Person(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public Person() {
		super();
	}

	// 如果不用eager策略，需要在DAO层保留session，也就是说不执行close操作
	// 生产环境下可以考虑手动实现certificates集合的赋值，在service层，调用CertificateDAO
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private Set<Certificate> certificates;

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}

}
