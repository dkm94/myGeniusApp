package com.example.mygenius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import okhttp3.OkHttpClient;

public class SearchActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listview = findViewById(R.id.listview);

        OkHttpClient client = new OkHttpClient();
        //String Url =
    }
}