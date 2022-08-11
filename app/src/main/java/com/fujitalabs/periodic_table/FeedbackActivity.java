package com.fujitalabs.periodic_table;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class FeedbackActivity extends AppCompatActivity {

    MaterialToolbar mtAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViews();
    }

    private void setViews() {
        setContentView(R.layout.activity_feedback);
        mtAppBar = findViewById(R.id.mt_app_bar);
        mtAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}