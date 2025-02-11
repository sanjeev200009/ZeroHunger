package com.example.zerohunger;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activityhome extends AppCompatActivity {

    private ViewPager2 viewPager;
    private final Handler sliderHandler = new Handler(Looper.getMainLooper());

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


        int[] images = {R.drawable.ban1, R.drawable.ban3, R.drawable.ban2};
        viewPager = findViewById(R.id.viewPager);
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, images);
        viewPager.setAdapter(adapter);
        startAutoSlide();

        int[] donationImages = {R.id.don1, R.id.don2, R.id.don3, R.id.don4};
        for (int id : donationImages) {
            ImageView donation = findViewById(id);
            if (donation != null) {
                donation.setOnClickListener(view -> {
                    Intent intent = new Intent(Activityhome.this, donrequestActivity.class);
                    startActivity(intent);
                });
            }
        }

        int[] agriImages = {R.id.agri1, R.id.agri2, R.id.agri3, R.id.agri4};
        for (int id : agriImages ) {
            ImageView donation = findViewById(id);
            if (donation != null) {
                donation.setOnClickListener(view -> {
                    Intent intent = new Intent(Activityhome.this, AgriTipsActivity.class);
                    startActivity(intent);
                });
            }
        }

        Button buttonNavigate = findViewById(R.id.btn_read);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activityhome.this, featuredpartnersActivity.class);
                startActivity(intent);
            }
        });


        Button buttonNavigate2 = findViewById(R.id.btn_join);
        buttonNavigate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activityhome.this, CommunityActivity.class);
                startActivity(intent);
            }
        });

        ImageView buttonNavigate3 = findViewById(R.id.profileIcon);
        buttonNavigate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activityhome.this, userprofileActivity.class);
                startActivity(intent);
            }
        });


        Button but = findViewById(R.id.don);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activityhome.this, FooddonActivity.class);
                startActivity(intent);
            }
        });



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    return true; // Stay on Home
                } else if (id == R.id.nav_search) {
                    startActivity(new Intent(Activityhome.this, serchActivity.class));
                    return true;
                } else if (id == R.id.nav_donation) {
                    startActivity(new Intent(Activityhome.this, MydonationActivity.class));
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Activityhome.this, userprofileActivity.class));
                    return true;
                }

                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_home);
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
    protected void onStop() {
        super.onStop();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startAutoSlide();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}
