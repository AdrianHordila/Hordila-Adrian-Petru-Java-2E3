package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resource implements Serializable {
    private String id;
    private String title;
    private String location;
    private int year;
    private String author;
    private String type; // tipul de date
    private Map<String, Object> tags = new HashMap<>();

    public Resource() {}
    ///  Constructor
    public Resource(String id, String title, String location, int year, String author, String type) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
        this.type = type;
    }

    // gettere si settere pentru afisare, asignare
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Map<String, Object> getTags() { return tags; }
    public void setTags(Map<String, Object> tags) { this.tags = tags; }
}