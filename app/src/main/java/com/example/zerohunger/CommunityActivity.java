package com.example.zerohunger;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CommunityActivity extends AppCompatActivity {
    private ImageView imagePreview;
    private EditText etName, etEmail, etLocation, etMessage;
    private Button btnUpload, btnSubmit;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imagePreview = findViewById(R.id.image_preview);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etLocation = findViewById(R.id.et_location);
        etMessage = findViewById(R.id.et_message);
        btnUpload = findViewById(R.id.btn_upload);
        btnSubmit = findViewById(R.id.btn_submit);

        btnUpload.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 100);
        });

        btnSubmit.setOnClickListener(v -> {
            if (validateInputs()) {
                showSuccessDialog();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imagePreview.setImageURI(imageUri);
        }
    }

    private boolean validateInputs() {
        if (etName.getText().toString().isEmpty() ||
                etEmail.getText().toString().isEmpty() ||
                etLocation.getText().toString().isEmpty() ||
                etMessage.getText().toString().isEmpty() ||
                imageUri == null) {

            Toast.makeText(this, "Please fill in all details and upload an image!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void showSuccessDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_success);
        dialog.setCancelable(false);

        TextView successText = dialog.findViewById(R.id.success_text);
        Button btnDone = dialog.findViewById(R.id.btn_done);

        successText.setText("Your details have been submitted successfully!");

        btnDone.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }
}
