package com.hongkailiu.test.app.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table(name = "certificate") public class Certificate implements Serializable {

    private static final long serialVersionUID = 5650067212639822933L;

    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;

    private String name;

    @ManyToOne @JoinColumn(name = "person_id", nullable = true) private Person person;

    public Certificate(int id, String name, Person person) {
        super();
        this.id = id;
        this.name = name;
        this.person = person;
    }

    public Certificate() {
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

    @Override public String toString() {
        return "id=" + id + ", name=" + name + ", person=" + person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
