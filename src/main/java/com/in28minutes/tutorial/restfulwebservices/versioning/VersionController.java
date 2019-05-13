package com.in28minutes.tutorial.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RA371996 on 4/16/2019.
 * Consider the following factors before versioning
 * URI pollution - in case of URI and request parameter types, URI will be polluted during versioning
 * Misuse of headers - The headers are not intended for versioning. so be careful before deciding to use header and media-type versioning
 * Caching - with header and media-type, caching is not possible
 * API dcoumentation - URI and request parameter types documentation can be managed with code but not the header and media-type
 */

@RestController
public class VersionController {

    //URI Versioning - Basic versioning. Create two methods
    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Rahul Pattar");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Patt", "Sagr"));
    }

    //Request Parameter versioning
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Rahul Pattar");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Patt", "Sagr"));
    }

    //Header versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Rahul Pattar");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Patt", "Sagr"));
    }

    //Media Type Versioning
    @GetMapping(value = "/person/produces", produces = "application/app-v1+json")
    public PersonV1 prodcuesV1(){
        return new PersonV1("Rahul Pattar");
    }

    @GetMapping(value = "/person/produces", produces = "application/app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Patt", "Sagr"));
    }

}
