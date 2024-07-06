package com.job_portal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ApplyJobActicity extends AppCompatActivity {
    ImageView backToJobDetail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_job_activity);
        backToJobDetail = findViewById(R.id.backToJobDetail);
        ImageView shareButton = findViewById(R.id.shareJobDetail);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareJobDetails();
            }
        });
        backToJobDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplyJobActicity.this, JobDetailActivity.class);
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
