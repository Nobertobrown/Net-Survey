package com.example.netsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {
    public EditText userName;
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.button);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button){
            String user = userName.getText().toString().trim();
            String pass = password.getText().toString().trim();

            Toast.makeText(this,"username: "+user+"\npassword: "+pass,Toast.LENGTH_SHORT).show();

            if (user.equals("coe") && pass.equals("od20")){
                Intent login = new Intent(this, AreaCoverage.class);
                startActivity(login);
            }
        }
    }
}