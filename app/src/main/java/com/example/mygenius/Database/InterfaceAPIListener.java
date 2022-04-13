package com.example.mygenius.Database;

import com.example.mygenius.Lyrics;

import java.util.ArrayList;

public interface InterfaceAPIListener {
    void onReceiveLyrics(ArrayList<Lyrics> lyrics);
}
