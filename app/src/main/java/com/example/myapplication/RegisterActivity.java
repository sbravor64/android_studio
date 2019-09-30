package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button botonRegistrar = findViewById(R.id.botonRegistrar);

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextUserName = findViewById(R.id.userName);
                EditText editTextUserEmail = findViewById(R.id.userEmail);
                EditText editTextUserPhone = findViewById(R.id.userPhone);
                EditText editTextUserPassword = findViewById(R.id.userPassword);

                String userName = editTextUserName.getText().toString();
                String userEmail = editTextUserEmail.getText().toString();
                String userPhone = editTextUserPhone.getText().toString();
                String userPassword = editTextUserPassword.getText().toString();

                if(userName.isEmpty()){
                    editTextUserName.setError("Nombre requerido");
                    return;
                }

                    Pattern pattern = Pattern
                            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                    Matcher mather = pattern.matcher(userEmail);

                    if (userEmail.isEmpty() || mather.find() == false) {
                        editTextUserEmail.setError("Email incorrecto");
                        return;
                    }

                if(userPassword.isEmpty()){
                    editTextUserPassword.setError("Password requerido");
                    return;
                }


                Intent intent = new Intent(RegisterActivity.this, ShowInfoActivity.class);

                intent.putExtra("USER_NAME", userName);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PHONE", userPhone);
                intent.putExtra("USER_PASSWORD", userPassword);

                startActivity(intent);
            }
        });

    }
}
