package com.example.mygenius;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Lyrics implements Serializable {
    private int id;
    private String artistName;
    private String title;
    private String lyrics;

    public Lyrics(){}

    public Lyrics(int id, String artistName, String title, String lyrics){
        this.id = id;
        this.artistName = artistName;
        this.title = title;
        this.lyrics = lyrics;
    }

    public static Lyrics jsonToLyrics(JSONObject object){
        Lyrics temp = new Lyrics();
        try {
            //temp.setId(object.getInt("id"));
            temp.setArtistName(object.getString("type"));
            temp.setTitle(object.getString("title"));
            temp.setLyrics(object.getString("lyrics"));
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
