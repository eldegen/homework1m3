package com.example.homework1m3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private ImageView ivPhoto;
    private EditText edUsername, edPassword;

    private static final int GALLERY_REQUEST_CODE = 1;
    private static final int CAMERA_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ivPhoto = findViewById(R.id.iv_photo);
        edUsername = findViewById(R.id.ed_wall_username);
        edPassword =  findViewById(R.id.ed_wall_password);

        edUsername.setText(getIntent().getStringExtra("Username"));
        edPassword.setText(getIntent().getStringExtra("Password"));
    }

    public void onEditPhotoClick(View view) {
        Intent galleryPicture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryPicture, GALLERY_REQUEST_CODE);
    }

    public void onAvatarClick(View view) {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            ivPhoto.setImageURI(selectedImage);
        }

        if (requestCode == 2 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivPhoto.setImageBitmap(imageBitmap);
        }

        if (requestCode == 3 && resultCode == RESULT_OK && data != null) {
            Toast.makeText(this, "data 3", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}