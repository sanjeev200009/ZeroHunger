package com.example.zerohunger;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class feedbackActivity extends AppCompatActivity {

    private EditText etName, etFeedback;
    private RatingBar ratingBar;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feedback);

        // Apply insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        ImageView signUpTextView = findViewById(R.id.imageView12);
        signUpTextView.setOnClickListener(view -> {
            startActivity(new Intent(feedbackActivity.this, Activityhome.class));
        });
        // Initialize UI components
        etName = findViewById(R.id.etName);
        etFeedback = findViewById(R.id.etFeedback);
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set click listener for submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        String name = etName.getText().toString().trim();
        String feedback = etFeedback.getText().toString().trim();
        float rating = ratingBar.getRating();

        // Basic validation
        if (name.isEmpty()) {
            etName.setError("Enter your name");
            etName.requestFocus();
            return;
        }
        if (feedback.isEmpty()) {
            etFeedback.setError("Enter your feedback");
            etFeedback.requestFocus();
            return;
        }
        if (rating == 0) {
            Toast.makeText(this, "Please rate us", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show success dialog after submission
        showSuccessDialog();
    }

    private void showSuccessDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_success);
        dialog.setCancelable(false);

        TextView successText = dialog.findViewById(R.id.success_text);
        Button btnDone = dialog.findViewById(R.id.btn_done);

        successText.setText("Your details have been submitted successfully!");

        btnDone.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}
