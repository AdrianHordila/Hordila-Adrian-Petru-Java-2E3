package com.bibliography.model;

import java.util.HashMap;
import java.util.Map;

public class Resource {
    private String id;
    private String title;
    private String location;
    private Map<String, Object> tags = new HashMap<>(); // Pentru autor, an, etc.

    public Resource(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void addTag(String key, Object value) {
        tags.put(key, value);
    }

    // Getters necesari
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return "Resource{id='" + id + "', title='" + title + "'}";
    }
}