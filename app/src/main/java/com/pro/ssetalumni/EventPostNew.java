package com.pro.ssetalumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventPostNew extends AppCompatActivity {
    EditText title,desc,dateformat,ehost;
    String titlesend,descsend,dateSend,hostSend;
    int year,month,day;

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_post_new);
        title=findViewById(R.id.title);
        desc=findViewById(R.id.desc);
        ehost=findViewById(R.id.eHost);
        dateformat=findViewById(R.id.dateformat);
        final Calendar calendar = Calendar.getInstance();
        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year= calendar.get(Calendar.YEAR);
                month= calendar.get(Calendar.MONTH);
                day= calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(EventPostNew.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();

        }

        public void AddEvent(View view) {
            titlesend=title.getText().toString();
            descsend=desc.getText().toString();
            dateSend=dateformat.getText().toString();
            hostSend=ehost.getText().toString();
            if(TextUtils.isEmpty(titlesend) || TextUtils.isEmpty(descsend)){
                return;
            }
            Add(titlesend,descsend,dateSend,hostSend);

        }

        private void Add(String titlesend, String descsend, String dateSend, String hostSend)
        {

            String id=mDatabase.push().getKey();
            Listdata listdata = new Listdata(id,titlesend, descsend,dateSend,hostSend);
            mDatabase.child("Events").child(id).setValue(listdata).
                    addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(EventPostNew.this, "Event Added", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),EventHomeScreen.class));
                        }
                    });
        }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Home.class));
    }
}
