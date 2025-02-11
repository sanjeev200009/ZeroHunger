package com.example.zerohunger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class userprofileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_userprofile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView buttonNavigate2 = findViewById(R.id.back);
        buttonNavigate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userprofileActivity.this, Activityhome.class);
                startActivity(intent);
            }
        });
        ImageView buttonNavigate3 = findViewById(R.id.imageView4);
        buttonNavigate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userprofileActivity.this, settingActivity.class);
                startActivity(intent);
            }
        });
        TextView signUpTextView = findViewById(R.id.textView211);
        signUpTextView.setOnClickListener(view -> {
            startActivity(new Intent(userprofileActivity.this, chngepswdActivity.class));
        });
    }
}