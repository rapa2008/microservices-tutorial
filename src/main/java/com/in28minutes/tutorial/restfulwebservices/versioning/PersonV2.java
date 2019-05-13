package com.in28minutes.tutorial.restfulwebservices.versioning;

/**
 * Created by RA371996 on 4/16/2019.
 */
public class PersonV2 {
    private Name name;

    public PersonV2() {
    }

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
