package com.example.homework1m3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout etUsername, etPassword;
    private Button btnGo;

    private static final int REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnGo = findViewById(R.id.btn_go);

        ImageView ivLogo = findViewById(R.id.iv_logo);

        Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(ivLogo);
    }

    public void onGoClick(View view) {
        if (etUsername.getEditText().length() == 0) {
            etUsername.setErrorEnabled(true);
            etUsername.setError("Username is empty!");
        } else {
            etUsername.setError("");
            etUsername.setErrorEnabled(false);
        }

        if (etPassword.getEditText().length() < 6) {
            etPassword.setErrorEnabled(true);
            etPassword.setError("Your password is less than 6 characters!");
        } else {
            etPassword.setError("");
            etPassword.setErrorEnabled(false);
        }

        if (etUsername.getEditText().length() != 0 && etPassword.getEditText().length() >= 6) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("Username", etUsername.getEditText().getText().toString());
            intent.putExtra("Password", etPassword.getEditText().getText().toString());

            startActivity(intent);
        }
    }
}