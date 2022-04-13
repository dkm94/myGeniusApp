package com.example.mygenius.Fragments;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mygenius.Helper;
import com.example.mygenius.Interfaces.Register;
import com.example.mygenius.R;

public class FragmentSearch extends Fragment implements View.OnClickListener {

    Helper helper;

    public FragmentSearch() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_search, null);
        return v;
    }

    @Override
    public void onClick(View view) {

    }
}