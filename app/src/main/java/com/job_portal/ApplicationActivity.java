package com.job_portal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.navigation_list); // Set the correct item as selected
        bottomNav.setOnItemSelectedListener(navListener);
    }

    private final BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {


                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();
                    if (itemId == R.id.navigation_home) {
                        startActivity(new Intent(ApplicationActivity.this, HomeActivity.class));
                        return true;
                    } else if (itemId == R.id.navigation_list) {
                        // Already on applications, do nothing
                        return true;
                    } else if (itemId == R.id.navigation_message) {
                        // Handle message navigation
                        return true;
                    } else if (itemId == R.id.navigation_profile) {
                        // Handle profile navigation
                        return true;
                    }
                    return false;
                }
            };
}
