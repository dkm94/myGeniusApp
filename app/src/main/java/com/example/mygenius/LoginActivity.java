package com.example.mygenius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin, btnRegister;
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email= (EditText) findViewById(R.id.email1);
        password= (EditText) findViewById(R.id.password1);
        btnLogin = (Button) findViewById(R.id.signIn1);
        btnRegister = (Button) findViewById(R.id.goToSignUp);
        helper = new Helper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = email.getText().toString();
                String passwordValue = password.getText().toString();

                if(emailValue.equals("") || passwordValue.equals("")){
                    Toast.makeText(LoginActivity.this, "Veuillez remplir tous les champs.", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkEmailPassword = helper.checkEmailPassword(emailValue, passwordValue);
                    if(checkEmailPassword){
                        Toast.makeText(LoginActivity.this, "Connexion réussie !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "La connexion a échoué. Veuillez réessayer.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}