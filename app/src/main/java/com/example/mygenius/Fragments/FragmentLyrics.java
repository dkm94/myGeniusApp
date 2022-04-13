package com.example.mygenius.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mygenius.R;

public class FragmentLyrics extends Fragment {

    TextView artistName, title, lyrics;

    public FragmentLyrics() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lyrics, null);

        artistName = v.findViewById(R.id.artistName);
        title= v.findViewById(R.id.title);
        lyrics= v.findViewById(R.id.lyrics);
        return v;
    }

}