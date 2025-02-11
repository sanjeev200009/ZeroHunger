package com.example.zerohunger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class serchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_serch);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView signUpTextView = findViewById(R.id.imageView12);
        signUpTextView.setOnClickListener(view -> {
            startActivity(new Intent(serchActivity.this, Activityhome.class));
        });
        ImageView signUpTextView2 = findViewById(R.id.icon1);
        signUpTextView2.setOnClickListener(view -> {
            startActivity(new Intent(serchActivity.this, Activityhome.class));
        });
        ImageView signUpTextView3 = findViewById(R.id.icon2);
        signUpTextView3.setOnClickListener(view -> {
            startActivity(new Intent(serchActivity.this, MydonationActivity.class));
        });
        ImageView signUpTextView4 = findViewById(R.id.icon3);
        signUpTextView4.setOnClickListener(view -> {
            startActivity(new Intent(serchActivity.this, settingActivity.class));
        });

        ImageView signUpTextView5 = findViewById(R.id.icon4);
        signUpTextView5.setOnClickListener(view -> {
            startActivity(new Intent(serchActivity.this, userprofileActivity.class));
        });
    }
}