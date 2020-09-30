package com.pro.ssetalumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonlogin;
    private EditText eTLEmailAddress,eTLPassword;
    private TextView registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTLEmailAddress = (EditText)findViewById(R.id.eTLtEmailAddress);
        eTLPassword = (EditText)findViewById((R.id.eTLPassword));
        registration = (TextView)findViewById(R.id.textView2);
        buttonlogin = (Button)findViewById(R.id.buttonlogin);

    /*  buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        }); */

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SSET_reg.class));
            }
        });

    }
  /*  private  void validate(String userName, String userPassword){
        if((userName=="Admin") && (userPassword=="1234")){
            Intent intent = new Intent(MainActivity.this, )
            start
        }*/

}