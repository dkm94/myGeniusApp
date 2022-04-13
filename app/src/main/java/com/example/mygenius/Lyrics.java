package com.example.mygenius;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Lyrics implements Serializable {
    private int id;
    private String name;
    private String title;
    private String image;
    private String lyrics;

    public Lyrics(){}

    public Lyrics(int id, String name, String title, String image, String lyrics){
        this.id = id;
        this.name = name;
        this.title = title;
        this.image = image;
        this.lyrics = lyrics;
    }

    public static Lyrics jsonToLyrics(JSONObject object){
        Lyrics temp = new Lyrics();
        try {
            temp.setId(object.getInt("id"));
            temp.setName(object.getJSONObject("name").getString("artist_names"));
            temp.setName(object.getJSONObject("title").getString("full_title"));
            temp.setImage(object.getJSONObject("image").getString("song_art_image_thumbnail_url"));
            temp.setLyrics(object.getJSONObject("lyrics").getString("url"));
        } catch (JSONException e){
            e.printStackTrace();
        }
        return temp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

}
