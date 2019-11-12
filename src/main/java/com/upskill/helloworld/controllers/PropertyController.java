package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.upskill.helloworld.models.Properties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * PropertyController
 */
@RestController
public class PropertyController {

    @GetMapping(value = "/property")
    public Properties property(){
        Properties property = createProperty();
        return property;
    }

    @GetMapping(value = "/property/{id}")
    public Properties userVarName(@PathVariable("id") int id) {
        Properties x = new Properties();
        x.setId(id);
        return x;
    }

    @GetMapping(value = "/properties")
    public List<Properties> properties() {
        ArrayList<Properties> properties = new ArrayList<>();
        properties.add(createProperty());
        properties.add(createProperty());
        properties.add(createProperty());
        properties.add(createProperty());

        return properties;
    }

    Properties createProperty(){
        Random random = new Random();
        Properties property = new Properties();
        property.setId(random.nextInt(100));
        property.setAddress("Persiaran Apec, Cyberjaya");
        property.setCreateAt("2019-11-12: 08:00");
        property.setUpdateAt("2019-11-12: 08:00");

        return property;
    }
}