package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.upskill.helloworld.models.Properties;
import com.upskill.helloworld.models.Review;
import com.upskill.helloworld.models.Tag;

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
        if(!result.isEmpty()){
            return result;
        }else{
            return properties;
        }
    }

    @GetMapping(value = "/property/{id}")
    public Properties showProperty(@PathVariable("id") int id) {
        Properties x = createProperty();
        x.setId(id);
        return x;
    }

    @GetMapping(value = "/property/{id}/tags")
    public List<Tag> showTags(@PathVariable("id") int id){
        ArrayList<Tag> tagList = createTags(id);

        return tagList;

    }

    @GetMapping(value = "/property/{id}/reviews")
    public List<Review> showReview(@PathVariable("id") int id){
        ArrayList<Review> reviewList = createReview(id);

        return reviewList;

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

    ArrayList<Tag> createTags(int property_id){
        ArrayList<Tag> tags = new ArrayList<>();
        String[] label = {"Apartment", "Penthouse", "Studio", "Sea View", "Duplex", "Balcony", "Condo"};
        Random rand = new Random();
        
        for(int id = 1; id < 4; id++){
            int randomId = rand.nextInt(7);
            Tag tag = new Tag();
            tag.setId(id);
            tag.setLabel(label[randomId]);
            tag.setProperty_id(property_id);

            tags.add(tag);
        }

        return tags;
    }

    ArrayList<Review> createReview(int property_id){
        ArrayList<Review> reviewList = new ArrayList<>();
        String[] reviews = {
            "Perfect Location",
            "Very Spacious",
            "OK quality"
        };
        String[] ratings = {"5/5","4/5","3/5"};
        String[] comments = {
            "In non ea anim eiusmod ipsum duis eu culpa labore commodo duis sint laboris.",
            "Cupidatat exercitation id labore elit non.",
            "Deserunt laborum reprehenderit dolor ipsum mollit aliquip ullamco dolor.",
            "Fugiat ex in deserunt irure qui eu ex culpa id commodo nostrud magna tempor adipisicing."
        };
        Random rand = new Random();

        for(int id = 1; id < 3; id++){
            int randomId = rand.nextInt(3);
            Review review = new Review();
            review.setId(id);
            review.setProperty_id(property_id);
            review.setRating(ratings[randomId]);
            review.setReview(reviews[randomId]);
            review.setComments(comments);

            reviewList.add(review);
        }

        return reviewList;
    }
}