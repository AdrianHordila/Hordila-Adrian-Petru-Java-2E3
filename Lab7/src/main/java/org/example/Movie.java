package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIES")
public class Movie {
    @Id
    private int id;
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    private int duration;
    private double score;


    public Movie() {}


    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getReleaseDate() { return releaseDate; }
    public int getDuration() { return duration; }
    public double getScore() { return score; }
}