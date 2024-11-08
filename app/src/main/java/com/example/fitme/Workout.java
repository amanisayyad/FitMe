package com.example.fitme;


public class Workout {
    private String name;
    private String difficulty;
    private String description;
    private String duration;

    public Workout(String name, String difficulty, String description,String duration) {
        this.name = name;
        this.difficulty = difficulty;
        this.description = description;
        this.duration=duration;
    }

    public String getName() {
        return name;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public String getDescription() {
        return description;
    }
    public String getDuration(){
        return duration;
    }
}
