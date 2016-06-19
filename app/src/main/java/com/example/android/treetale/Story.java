package com.example.android.treetale;

/**
 * Created by nj_km on 19/06/2016.
 */
public class Story {

    private int id;
    private String title;
    private String description;

    public Book(){}

    public Book(String title, String description)(){
        super();
        this.title = title;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String toString() {
        return "Story [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
}
