package com.example.mygenius.Interfaces;

import com.example.mygenius.Lyrics;

import java.util.ArrayList;

public interface ApiListener {
    public void onReceiveLyrics(ArrayList<Lyrics> lyrics);
}
