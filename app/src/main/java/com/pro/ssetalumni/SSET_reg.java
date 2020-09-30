package com.pro.ssetalumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SSET_reg extends AppCompatActivity {

    private EditText userName, userPassword, userEmail, userPhone;
    private Button regButton;
    private TextView userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_s_e_t_reg);
        setupUIViews();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate() ){
                    //Upload the data to the database

                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SSET_reg.this, MainActivity.class));
            }
        });
    }
    private  void  setupUIViews(){
        userName = (EditText)findViewById(R.id.eTPersonName);
        userEmail = (EditText)findViewById(R.id.eTREmailAddress);
        userPassword = (EditText)findViewById(R.id.eTRPassword);
        userPhone = (EditText)findViewById(R.id.eTRPhone);
        regButton = (Button)findViewById(R.id.buttonRegister);
        userLogin =(TextView)findViewById(R.id.textView5);
    }
    private Boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty() ){
            Toast.makeText(this,"Please enter all the details", Toast.LENGTH_SHORT);
        }else{
            result=true;
        }
        return result;
    }
}