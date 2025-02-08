package com.example.zerohunger;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signupActivity extends AppCompatActivity {

    private EditText fullName, email, password;
    private Spinner roleSpinner;
    private Button signupButton;
    private String selectedRole = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullName = findViewById(R.id.editTextTextEmailAddress);
        email = findViewById(R.id.editTextpassword);
        password = findViewById(R.id.editTextpassword2);
        roleSpinner = findViewById(R.id.roleSpinner);
        signupButton = findViewById(R.id.btn_strt);


        ImageView buttonNavigate3 = findViewById(R.id.back_arrow);
        buttonNavigate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signupActivity.this, signinActivity.class);
                startActivity(intent);
            }
        });

        TextView terms = findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signupActivity.this, Activity_termscondition.class);
                startActivity(intent);
            }
        });




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.roles_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRole = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedRole = "";
            }
        });

        signupButton.setOnClickListener(view -> registerUser());
    }



    private void registerUser() {
        String name = fullName.getText().toString().trim();
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        if (name.isEmpty()) {
            fullName.setError("Full name is required");
            fullName.requestFocus();
            return;
        }

        if (emailInput.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Enter a valid email");
            email.requestFocus();
            return;
        }

        if (passwordInput.isEmpty() || passwordInput.length() < 6) {
            password.setError("Password must be at least 6 characters");
            password.requestFocus();
            return;
        }

        if (selectedRole.equals("") || selectedRole.equals("Select your role")) {
            Toast.makeText(this, "Please select a valid role", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(signupActivity.this, signinActivity.class));
        finish();
    }
}
