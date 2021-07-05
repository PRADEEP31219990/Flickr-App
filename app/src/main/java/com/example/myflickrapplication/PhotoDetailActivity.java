package com.example.myflickrapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activateToolbar(true);

        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);
        if(photo != null){
            TextView photoTitle = findViewById(R.id.photo_title);
            photoTitle.setText("Title: " + photo.getTitle());
            TextView phototags = findViewById(R.id.photo_tags);
            phototags.setText("Tags : " + photo.getTags());
            TextView photoAuthor = findViewById(R.id.photo_author);
            photoAuthor.setText(photo.getAuthor());
            ImageView imageView = findViewById(R.id.photo_image);
            Picasso.with(this).load(photo.getLink()).error(R.drawable.placeholder).placeholder(R.drawable.placeholder).into(imageView);
        }
    }
}