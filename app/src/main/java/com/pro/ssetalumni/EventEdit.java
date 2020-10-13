package com.pro.ssetalumni;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventEdit extends AppCompatActivity {
    EditText title, desc, date, host;
    String titlesend, descsend, datesend, hostsend;
    private DatabaseReference mDatabase;
    private Listdata listdata;
    Button updates, delete;
    int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        updates = findViewById(R.id.updatesbutton);
        delete = findViewById(R.id.deletedbutton);
        date=findViewById(R.id.dateformat);
        final Calendar calendar = Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year= calendar.get(Calendar.YEAR);
                month= calendar.get(Calendar.MONTH);
                day= calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(EventEdit.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });

        final Intent i = getIntent();
        String gettitle = i.getStringExtra("title");
        String getdesc = i.getStringExtra("desc");
        String getdate = i.getStringExtra("date");
        String gethost = i.getStringExtra("host");
        final String id = i.getStringExtra("id");


        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        date = findViewById(R.id.dateformat);
        host = findViewById(R.id.eHost);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        title.setText(gettitle);
        desc.setText(getdesc);
        date.setText(getdate);
        host.setText(gethost);
        updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
                UpdateEvents(id);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
                deleteEvents(id);
            }
        });
    }

    private void UpdateEvents(String id) {
        titlesend = title.getText().toString();
        descsend = desc.getText().toString();
        datesend = date.getText().toString();
        hostsend = host.getText().toString();
        Listdata listdata = new Listdata(id, titlesend, descsend, datesend , hostsend);
        mDatabase.child("Events").child(id).setValue(listdata).
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(EventEdit.this, "Events Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), EventHomeScreen.class));
                    }
                });
    }

    private void deleteEvents(String id) {
        mDatabase.child("Events").child(id).removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EventEdit.this, "Events Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), EventHomeScreen.class));

                    }
                });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Home.class));
    }
}

