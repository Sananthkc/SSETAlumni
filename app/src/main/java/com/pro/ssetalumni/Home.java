package com.pro.ssetalumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//......................HOOKS.......................

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);





        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Handle navigation view item clicks here.

                switch (item.getItemId()) {

                    case R.id.nav_pro:
                        Intent intent = new Intent (Home.this, Dashboard.class);
                        startActivity(intent);
                        intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case R.id.nav_post:
                        Intent i = new Intent (Home.this, NewPost.class);
                        startActivity(i);

                        break;
                    case R.id.nav_event:

                        break;
                    case R.id.nav_jobs:

                        break;
                    case R.id.nav_logout:


                        break;
                }

                return true;
            }

        });



    }
}