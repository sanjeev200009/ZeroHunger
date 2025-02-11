package com.example.zerohunger;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class AgriTipsActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private final Handler sliderHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agri_tips);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int[] images = {R.drawable.agri2, R.drawable.agri3, R.drawable.agri4};
        viewPager = findViewById(R.id.viewPager);
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, images);
        viewPager.setAdapter(adapter);
        startAutoSlide();

        ImageView buttonNavigate2 = findViewById(R.id.back);
        buttonNavigate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgriTipsActivity.this, Activityhome.class);
                startActivity(intent);
            }
        });


        LinearLayout buttonNavigate3 = findViewById(R.id.tip);
        buttonNavigate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgriTipsActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });

    }


    private void startAutoSlide() {
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = viewPager.getCurrentItem();
            int nextItem = (currentItem + 1) % 3;
            viewPager.setCurrentItem(nextItem, true);
            sliderHandler.postDelayed(this, 4000);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}