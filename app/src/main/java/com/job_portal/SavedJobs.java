package com.job_portal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SavedJobs extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_jobs_activity);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.navigation_bookmark); // Set the correct item as selected
        bottomNav.setOnItemSelectedListener(navListener);
    }

    private final BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {


                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();
                    if (itemId == R.id.navigation_home) {
                        startActivity(new Intent(SavedJobs.this, HomeActivity.class));
                        return true;
                    } else if (itemId == R.id.navigation_application) {
                        startActivity(new Intent(SavedJobs.this, ApplicationActivity.class));

                        // Already on applications, do nothing
                        return true;
                    } else if (itemId == R.id.navigation_bookmark) {
                        return true;
                    } else if (itemId == R.id.navigation_profile) {
                        startActivity(new Intent(SavedJobs.this, ProfileActivity.class));
                        return true;
                    }
                    return false;
                }
            };
}