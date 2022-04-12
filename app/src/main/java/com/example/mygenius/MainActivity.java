package com.example.mygenius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //FragmentLogin fragmentLogin;
    //FragmentRegister fragmentRegister;
    //FragmentSearch fragmentSearch;
    //FragmentFarovite fragmentFavorite;
    //FragmentLyrics fragmentLyrics;

    EditText username, email, password, confirmPassword;
    Button signUp, signIn;
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        signUp = (Button) findViewById(R.id.signUp);
        signIn = (Button) findViewById(R.id.goToSignIn);
        helper = new Helper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String emailValue = email.getText().toString();
                String passwordValue = password.getText().toString();
                String confirmPasswordValue = confirmPassword.getText().toString();

                if(usernameValue.equals("") || emailValue.equals("") || passwordValue.equals("") || confirmPasswordValue.equals("")){
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs.", Toast.LENGTH_LONG).show();
                } else {
                    if(passwordValue.equals(confirmPasswordValue)){
                        Boolean checkEmailValue = helper.checkEmail(emailValue);
                        if(checkEmailValue==false){
                            Boolean insert = helper.insertData(usernameValue, emailValue, passwordValue);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Le compte a été créé avec succès, vous pouvez à présent vous connecter", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Erreur connexion. Veuillez réessayer.", Toast.LENGTH_LONG).show();
                            }
                        } else {
                        Toast.makeText(MainActivity.this, "L'utilisateur existe déjà. Veuillez choisir une autre adresse mail.", Toast.LENGTH_SHORT).show();
                        }
                    } else
                    Toast.makeText(MainActivity.this, "La confirmation doit correspondre au mot de passe. Veuillez réessayer.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }


}