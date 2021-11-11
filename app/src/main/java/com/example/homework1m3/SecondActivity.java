package com.example.homework1m3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    private ImageView ivPhoto;
    private String fileManagerString, selectedImgPath;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ivPhoto = findViewById(R.id.iv_photo);
    }

    public void onEditPhotoClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE);


    }

    public void onAvatarClick(View view) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            ivPhoto.setImageURI(selectedImage);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}