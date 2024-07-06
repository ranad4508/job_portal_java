package com.job_portal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JobDetailActivity extends AppCompatActivity {
    ImageView backToHome;
    Button applyNow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_detail_activity);
        backToHome = findViewById(R.id.backToHome);
        applyNow = findViewById(R.id.applyNow);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JobDetailActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        ImageView shareButton = findViewById(R.id.shareJobDetail);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareJobDetails();
            }
        });


        applyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JobDetailActivity.this, ApplyJobActicity.class);
                startActivity(intent);
            }
        });
    }
    private void shareJobDetails() {
        String shareBody = "Check out this job opening at AirBNB: UI/UX Designer.\nSalary: $2,350\nType: Full Time\nLocation: United States";

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Opening at AirBNB");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
