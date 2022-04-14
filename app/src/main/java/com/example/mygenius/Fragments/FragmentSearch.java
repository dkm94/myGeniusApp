package com.example.mygenius.Fragments;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.mygenius.Database.InterfaceAPIListener;
import com.example.mygenius.Helper;
import com.example.mygenius.Interfaces.ApiListener;
import com.example.mygenius.Interfaces.LyricsSelected;
import com.example.mygenius.Interfaces.Register;
import com.example.mygenius.Lyrics;
import com.example.mygenius.LyricsAdapter;
import com.example.mygenius.R;
import com.example.mygenius.Services.LyricsService;

import java.util.ArrayList;

public class FragmentSearch extends Fragment implements View.OnClickListener, ApiListener, AdapterView.OnItemClickListener, InterfaceAPIListener {

    Helper helper;
    ArrayList<Lyrics> lyricsList;
    LyricsAdapter adapter;
    ListView listViewLyrics;
    EditText searchInput;
    ImageButton imageButtonSearch;
    LyricsSelected listenerLyricsSelected;

    public FragmentSearch() {
    }

    public void setListenerLyricsSelected(LyricsSelected listenerLyricsSelected) {
        this.listenerLyricsSelected = listenerLyricsSelected;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_search, null);

        listViewLyrics= v.findViewById(R.id.listViewLyrics);
        lyricsList= new ArrayList<Lyrics>();

        //lyricsList.add(new Lyrics(23222, "ABBA", "Mamamia", "Blablabla"));
        //lyricsList.add(new Lyrics(23342, "Queen", "Another one bites the dust", "Blablabla Blablabla Blablabla BlablablaBlablabla"));

        adapter = new LyricsAdapter(getContext(), lyricsList);
        listViewLyrics.setAdapter(adapter);
        listViewLyrics.setOnItemClickListener(this);

        searchInput = v.findViewById(R.id.searchInput);
        imageButtonSearch = v.findViewById(R.id.imageButtonSearch);
        imageButtonSearch.setOnClickListener(this);


        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Lyrics lyrics = lyricsList.get(i);
        listenerLyricsSelected.onSelectLyrics(lyrics);
    }

    @Override
    public void onClick(View view) {
        LyricsService.searchLyrics(getContext(), searchInput.getText().toString(), this);
    }

    @Override
    public void onReceiveLyrics(ArrayList<Lyrics> lyrics) {
        this.lyricsList = lyrics;
        adapter = new LyricsAdapter(getContext(), lyrics);
        listViewLyrics.setAdapter(adapter);
    }

}