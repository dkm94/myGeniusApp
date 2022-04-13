package com.example.mygenius.Fragments;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mygenius.Helper;
import com.example.mygenius.Interfaces.Login;
import com.example.mygenius.R;

public class FragmentRegister extends Fragment implements View.OnClickListener {

    EditText username, email, password, confirmPassword;
    Button signUp, signIn;
    Helper helper;
    Login listenerLogin;

    public void setListenerLogin(Login listenerLogin){
        this.listenerLogin = listenerLogin;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, null);

        username = v.findViewById(R.id.username);
        email = v.findViewById(R.id.email);
        password = v.findViewById(R.id.password);
        confirmPassword = v.findViewById(R.id.confirmPassword);
        signUp = v.findViewById(R.id.signUp);
        signUp.setOnClickListener(this);
        signIn = v.findViewById(R.id.goToSignIn);
        signIn.setOnClickListener(this);
        helper = new Helper(getContext());

        return v;
    }

    @Override
    public void onClick(View view) {
        if(view.equals(signUp)){
            String usernameValue = username.getText().toString();
            String emailValue = email.getText().toString();
            String passwordValue = password.getText().toString();
            String confirmPasswordValue = confirmPassword.getText().toString();

            if(usernameValue.equals("") || emailValue.equals("") || passwordValue.equals("") || confirmPasswordValue.equals("")){
                Toast.makeText(getContext(), "Veuillez remplir tous les champs.", Toast.LENGTH_LONG).show();
            } else {
                if(passwordValue.equals(confirmPasswordValue)){
                    Boolean checkEmailValue = helper.checkEmail(emailValue);
                    if(!checkEmailValue){
                        Boolean insert = helper.insertData(usernameValue, emailValue, passwordValue);
                        if(insert){
                            Toast.makeText(getContext(), "Le compte a été créé avec succès, vous pouvez à présent vous connecter", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getContext(), LoginActivity.class);
//                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Erreur connexion. Veuillez réessayer.", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "L'utilisateur existe déjà. Veuillez choisir une autre adresse mail.", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(getContext(), "La confirmation doit correspondre au mot de passe. Veuillez réessayer.", Toast.LENGTH_SHORT).show();
            }

        } else {
            listenerLogin.login();
        }

}
}