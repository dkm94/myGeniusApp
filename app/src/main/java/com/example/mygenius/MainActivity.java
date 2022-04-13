package com.example.mygenius;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mygenius.Fragments.FragmentLogin;
import com.example.mygenius.Fragments.FragmentRegister;
import com.example.mygenius.Interfaces.Login;
import com.example.mygenius.Interfaces.Register;

public class MainActivity extends AppCompatActivity implements Login, Register {

    FragmentLogin fragmentLogin;
    FragmentRegister fragmentRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentLogin= new FragmentLogin();
        fragmentRegister= new FragmentRegister();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, fragmentLogin)
                .add(R.id.frameLayout, fragmentRegister)
                .hide(fragmentRegister)
                .commit();
    }

    @Override
    public void login() {

    }

    @Override
    public void register() {

    }
}
