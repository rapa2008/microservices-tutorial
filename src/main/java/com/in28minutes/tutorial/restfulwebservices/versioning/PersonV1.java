package com.in28minutes.tutorial.restfulwebservices.versioning;

/**
 * Created by RA371996 on 4/16/2019.
 */
public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
