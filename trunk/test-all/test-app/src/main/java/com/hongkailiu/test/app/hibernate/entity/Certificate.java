package com.hongkailiu.test.app.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="certificate")
public class Certificate {
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
     
    private String name;
    
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
     
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
      
    @Override
    public String toString(){
        return "id="+id+", name="+name+", person="+person;
    }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Certificate(int id, String name, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.person = person;
	}
    
	public Certificate() {
		super();
	}
    
}
