package com.upskill.helloworld.models;

/**
 * Review
 */
public class Review {

    private int id;
    private String review;
    private String rating;
    private int property_id;
    private String[] comments;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getProperty_id() {
        return this.property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String[] getComments() {
        return this.comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}