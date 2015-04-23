package com.hongkailiu.test.app.hibernate.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity @Table(name = "Person") public class Person implements Serializable {

    private static final long serialVersionUID = 3233110155779286919L;

    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;

    private String name;

    private String country;
    // 如果不用eager策略，需要在DAO层保留session，也就是说不执行close操作
    // 生产环境下可以考虑手动实现certificates集合的赋值，在service层，调用CertificateDAO
    // ref. https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/performance.html
    // inverse http://stackoverflow.com/questions/4865285/inverse-true-in-jpa-annotations
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    @Fetch(FetchMode.SELECT)
    //@JoinColumn(name = "person_id")
    //@Cascade({CascadeType.SAVE_UPDATE})
    private Set<Certificate> certificates;

    public Person(int id, String name, String country) {
        super();
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Person() {
        super();
    }

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

    @Override public String toString() {
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

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<Certificate> certificates) {
        this.certificates = certificates;
    }

}
