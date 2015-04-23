package com.hongkailiu.test.app.db;


public class Person {


    private int id;

    private String name;

    private String country;

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



}
