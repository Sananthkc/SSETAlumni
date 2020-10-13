package com.pro.ssetalumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventPostNew extends AppCompatActivity {
    EditText title,desc;
    String titlesend,descsend;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_post_new);
        title=findViewById(R.id.title);
        desc=findViewById(R.id.desc);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        }

        public void AddEvent(View view) {
            titlesend=title.getText().toString();
            descsend=desc.getText().toString();
            if(TextUtils.isEmpty(titlesend) || TextUtils.isEmpty(descsend)){
                return;
            }
            Add(titlesend,descsend);

        }

        private void Add(String titlesend, String descsend)
        {

            String id=mDatabase.push().getKey();
            Listdata listdata = new Listdata(id,titlesend, descsend);
            mDatabase.child("Events").child(id).setValue(listdata).
                    addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(EventPostNew.this, "Event Added", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),EventHomeScreen.class));
                        }
                    });
        }
    }
