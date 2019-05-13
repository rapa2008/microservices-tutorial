package com.in28minutes.tutorial.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RA371996 on 4/15/2019.
 */
@RestController
public class FilteringController {
    /* Dynamic filtering using MappingJacksonValue
    * */
    @GetMapping("/filtering")
    public MappingJacksonValue getBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters;
        filters = new SimpleFilterProvider().addFilter("SomeBean", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue getListBeans(){
        List<SomeBean> someBeans = new ArrayList<>();

        someBeans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value11", "value21", "value31"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

        FilterProvider filters;
        filters = new SimpleFilterProvider().addFilter("SomeBean", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
        mapping.setFilters(filters);

        return mapping;
    }
}
