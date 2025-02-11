package com.example.zerohunger;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class signinActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Initialize UI components
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextpassword);
        loginButton = findViewById(R.id.btn_strt);

        // Set background tint for buttons
        Button buttonFacebook = findViewById(R.id.btnFacebook);
        buttonFacebook.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.darkblue)));

        Button buttonGoogle = findViewById(R.id.btnGoogle);
        buttonGoogle.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue)));

        // Navigate to Sign-up Activity
        TextView signUpTextView = findViewById(R.id.textView6);
        signUpTextView.setOnClickListener(view -> {
            startActivity(new Intent(signinActivity.this, signupActivity.class));
        });

        // Navigate to Forgot Password Activity
        TextView forgotPasswordTextView = findViewById(R.id.textView4);
        forgotPasswordTextView.setOnClickListener(view -> {
            startActivity(new Intent(signinActivity.this, ForgotPassActivity.class));
        });


        ImageView backButton = findViewById(R.id.back_arrow);
        backButton.setOnClickListener(View -> {
            startActivity(new Intent(signinActivity.this, MainActivity.class));
        });

        // Set onClickListener for login button
        loginButton.setOnClickListener(view -> loginUser());
    }

    private void loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Validate email
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        // Validate password
        if (password.isEmpty() || password.length() < 6) {
            editTextPassword.setError("Password must be at least 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        // Simulate user authentication (Replace with Firebase or Database authentication)
        if (email.equals("test@example.com") && password.equals("123456")) {
            showSuccessDialog();
        } else {
            Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
        }
    }
    private void showSuccessDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_success);
        dialog.setCancelable(false);

        TextView successText = dialog.findViewById(R.id.success_text);
        Button btnDone = dialog.findViewById(R.id.btn_done);

        successText.setText("Login Successful! Thank you for Your Login");

        btnDone.setOnClickListener(v -> {
            dialog.dismiss();
            // Navigate to locationActivity5 after closing dialog
            startActivity(new Intent(signinActivity.this, locationActivity5.class));
            finish();
        });

        dialog.show();
    }
}
