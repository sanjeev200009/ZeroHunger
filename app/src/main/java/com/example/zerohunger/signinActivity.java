package com.example.zerohunger;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signinActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the button and apply background tint
        Button button = findViewById(R.id.btnFacebook);
        button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.darkblue)));

        Button button2 = findViewById(R.id.btnGoogle);
        button2.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue)));

    }
}
