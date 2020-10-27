package com.pro.ssetalumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;
    private ProgressBar mProgressCircle;
    private DatabaseReference mDatabaseRef;
    private List<UploadImage> mUploads;

    String fullname;
    TextView fullName;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.action_Posts);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_Posts:

                        return true;
                    case R.id.action_Events:
                        startActivity(new Intent(getApplicationContext(),EventHomeScreen.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.action_jobs:
                        startActivity(new Intent(getApplicationContext(),JobsHomeScreen.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

//......................HOOKS.......................
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();




/*
        Intent intent = getIntent();
        fullname= intent.getStringExtra("full_name_from_login");
        fullName  = findViewById(R.id.name_poster);
        fullName.setText(fullname);
*/
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Handle navigation view item clicks here.

                switch (item.getItemId()) {

                    case R.id.nav_pro:
                        Intent intent = new Intent(Home.this, Dashboard.class);
                        startActivity(intent);
                        intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case R.id.nav_post:
                        Intent i = new Intent(Home.this, NewPost.class);
                        startActivity(i);

                        break;
                    case R.id.nav_event:

                        Intent j = new Intent(Home.this, EventPostNew.class);
                        startActivity(j);
                        finish();
                        break;
                    case R.id.nav_jobs:

                        Intent k = new Intent(Home.this, Newjobs.class);
                        startActivity(k);
                        finish();

                        break;
                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();//logout
                        startActivity(new Intent(getApplicationContext(), Login.class));
                        finish();


                        break;


                }

                return true;
            }

        });

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgressCircle = findViewById(R.id.progress_circle);

        mUploads = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");



        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mUploads.clear();       //for clearing the list every time a post is added...if not done, then the entire posts will gets merged again and again
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {



                    UploadImage upload = postSnapshot.getValue(UploadImage.class);

                    mUploads.add(upload);

                }
                mAdapter = new ImageAdapter(Home.this, mUploads);
                mRecyclerView.setAdapter(mAdapter);
                mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Home.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });


    }

}