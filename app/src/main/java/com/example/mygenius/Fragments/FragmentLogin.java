package com.example.mygenius.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mygenius.Helper;
import com.example.mygenius.Interfaces.Register;
import com.example.mygenius.Interfaces.Search;
import com.example.mygenius.R;

public class FragmentLogin extends Fragment implements View.OnClickListener{

    public FragmentLogin() {
        // Required empty public constructor
    }

    EditText email, password;
    Button btnLogin, btnRegister;
    Helper helper;
    Register listenerRegister;
    Search listenerSearch;

    public void setListenerRegister(Register listenerRegister){
        this.listenerRegister = listenerRegister;
    }

    public void setListenerSearch(Search listenerSearch){
        this.listenerSearch = listenerSearch;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, null);

        email= v.findViewById(R.id.email1);
        password= v.findViewById(R.id.password1);
        btnLogin = v.findViewById(R.id.signIn1);
        btnLogin.setOnClickListener(this);
        btnRegister = v.findViewById(R.id.goToSignUp);
        btnRegister.setOnClickListener(this);
        helper = new Helper(getContext());

        return v;
    }

    @Override
    public void onClick(View view) {
        if(view.equals(btnLogin)){
            String emailValue = email.getText().toString();
            String passwordValue = password.getText().toString();

            if(emailValue.equals("") || passwordValue.equals("")){
                Toast.makeText(getContext(), "Veuillez remplir tous les champs.", Toast.LENGTH_LONG).show();
            } else {
                Boolean checkEmailPassword = helper.checkEmailPassword(emailValue, passwordValue);
                if(checkEmailPassword){
                    Toast.makeText(getContext(), "Connexion réussie !", Toast.LENGTH_LONG).show();
                    listenerSearch.search();
                } else {
                    Toast.makeText(getContext(), "La connexion a échoué. Veuillez réessayer.", Toast.LENGTH_LONG).show();
                }
            }
        } else if(view.equals(btnRegister)){
            listenerRegister.register();
        } else return ;
    }
}