package com.pro.ssetalumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AdminLogin extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView userbutton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        mEmail = findViewById(R.id.eTLtEmailAddress);
        mPassword = findViewById(R.id.eTLPassword);
        progressBar = findViewById(R.id.progressBarLogin);

        mLoginBtn = findViewById(R.id.buttonlogin);
        userbutton = findViewById(R.id.userbutton);

    userbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(AdminLogin.this,Login.class);
            startActivity(i);

        }
    });
    mLoginBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(AdminLogin.this,admin_home.class);
            startActivity(i);
        }
    });
    }
}