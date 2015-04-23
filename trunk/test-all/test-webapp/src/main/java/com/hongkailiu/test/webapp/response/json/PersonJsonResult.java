package com.hongkailiu.test.webapp.response.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) public class PersonJsonResult
    extends BaseJsonResult {

    private long id;
    private String username;
    private String password;
    private Date birthdate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


}
