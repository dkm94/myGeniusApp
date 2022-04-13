package com.example.mygenius;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mygenius.Fragments.FragmentLogin;
import com.example.mygenius.Fragments.FragmentLyrics;
import com.example.mygenius.Fragments.FragmentRegister;
import com.example.mygenius.Fragments.FragmentSearch;
import com.example.mygenius.Interfaces.Login;
import com.example.mygenius.Interfaces.LyricsSelected;
import com.example.mygenius.Interfaces.Register;
import com.example.mygenius.Interfaces.Search;

public class MainActivity extends AppCompatActivity implements Login, Register, Search, LyricsSelected {

    FragmentLogin fragmentLogin;
    FragmentRegister fragmentRegister;
    FragmentSearch fragmentSearch;
    FragmentLyrics fragmentLyrics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentLogin= new FragmentLogin();
        fragmentLogin.setListenerRegister(this);
        fragmentLogin.setListenerSearch(this);
        fragmentRegister= new FragmentRegister();
        fragmentRegister.setListenerLogin(this);
        fragmentSearch= new FragmentSearch();
        fragmentSearch.setListenerLyricsSelected(this);
        fragmentLyrics= new FragmentLyrics();


        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, fragmentLogin)
                .add(R.id.frameLayout, fragmentRegister)
                .add(R.id.frameLayout, fragmentSearch)
                .hide(fragmentLogin)
                .hide(fragmentSearch)
                .commit();
    }

    @Override
    public void login() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentRegister)
                .show(fragmentLogin)
                .commit();
    }

    @Override
    public void register() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentLogin)
                .show(fragmentRegister)
                .commit();
    }


    @Override
    public void search() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentLogin)
                .show(fragmentSearch)
                .commit();
    }

    @Override
    public void onSelectLyrics(Lyrics lyrics) {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentSearch)
                .show(fragmentLyrics)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(fragmentLyrics.isVisible()) {
            getSupportFragmentManager().beginTransaction()
                    .hide(fragmentLyrics)
                    .show(fragmentSearch)
                    .commit();
        }else{
            super.onBackPressed();
        }
    }
}
