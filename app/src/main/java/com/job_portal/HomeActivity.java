package com.job_portal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    TextView seeAllJobs;
    ImageView appLogo;
    TextView seeAllTips;
    Button readMoreTips;
    ImageView notificationIcon;
    LinearLayout jobItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);

        seeAllJobs = findViewById(R.id.seeAllJobs);
        appLogo = findViewById(R.id.appLogo);
        seeAllTips = findViewById(R.id.seeAllTips);
        readMoreTips = findViewById(R.id.readMoreTips);
        notificationIcon = findViewById(R.id.notificationIcon);
        jobItem = findViewById(R.id.jobItem);

//        click on see all job recommendation
        seeAllJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, JobRecommendationActivity.class);
                startActivity(intent);
            }
        });

//        click on app logo
        appLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
//        read more tips
        readMoreTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TipsDetailActicity.class);
                startActivity(intent);
            }
        });
//        notification icon
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

//        see all tips
        seeAllTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });

//        View job item on click
        jobItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, JobDetailActivity.class);
                startActivity(intent);
            }
        });


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);
    }

    private final BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();
                    if (itemId == R.id.navigation_home) {
                        // Already on home, do nothing
                        return true;
                    } else if (itemId == R.id.navigation_list) {
                        // Navigate to ApplicationActivity
                        Intent intent = new Intent(HomeActivity.this, ApplicationActivity.class);
                        startActivity(intent);
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