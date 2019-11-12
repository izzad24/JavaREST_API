package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;

import com.upskill.helloworld.models.Properties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PropertyController
 */
@RestController
public class PropertyController {

    @GetMapping(value = "/property")
    public List<Properties> property(@RequestParam(name = "location", required = false) String location){
        ArrayList<Properties> properties = seedProperties();
        ArrayList<Properties> result = new ArrayList<>();
        for (Properties property : properties) {
            if(property.getLocation().equalsIgnoreCase(location)){
                result.add(property);
            }
        }
        return result;
    }

    // @GetMapping(value = "/property/{id}")
    // public Properties showProperty(@PathVariable("id") int id) {
    //     Properties x = createProperty();
    //     x.setId(id);
    //     return x;
    // }

    @GetMapping(value = "/properties")
    public List<Properties> properties() {
        ArrayList<Properties> properties = new ArrayList<>();
        properties.add(createProperty());
        properties.add(createProperty());
        properties.add(createProperty());
        properties.add(createProperty());

        return properties;
    }

    @PostMapping(value="/create_property")
    public Properties create(@RequestBody Properties property){
        Properties x = createProperty();
        x.setAddress(property.getAddress());
        x.setLocation(property.getLocation());
        return x;
    }

    Properties createProperty(){
        Properties property = new Properties();
        property.setAddress("Persiaran Apec, Cyberjaya");
        property.setCreateAt("2019-11-12: 08:00");
        property.setUpdateAt("2019-11-12: 08:00");
        property.setLocation("KL");

        return property;
    }

    ArrayList<Properties> seedProperties(){
        ArrayList<Properties> properties = new ArrayList<>();
        for(int id = 1; id < 11; id++){
            Properties property = createProperty();
            property.setId(id);
            properties.add(property);
        }

        properties.get(0).setLocation("Klang Valley");
        properties.get(4).setLocation("Cyberjaya");
        properties.get(7).setLocation("Klang");

        return properties;
    }
}