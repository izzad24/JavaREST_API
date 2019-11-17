package com.upskill.helloworld.models;

/**
 * Tag
 */
public class Tag {

    private int id;
    private String label;
    private int property_id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getProperty_id() {
        return this.property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

}