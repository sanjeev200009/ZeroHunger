package com.example.zerohunger;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class Activityhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activityhome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Set up the image slider (ViewPager2)
        int[] images = {R.drawable.homeimg, R.drawable.homeimg, R.drawable.homeimg};  // Replace with your drawable images
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, images);
        viewPager.setAdapter(adapter);
    }
}