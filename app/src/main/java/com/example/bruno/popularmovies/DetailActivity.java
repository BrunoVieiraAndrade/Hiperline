package com.example.bruno.popularmovies;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bruno.popularmovies.pojo.ImageItem;
import com.squareup.picasso.Picasso;

import java.io.File;

public class DetailActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView moviePosterImageView = (ImageView) findViewById(R.id.movie_poster_image_view);
        TextView movieTitle = (TextView) findViewById(R.id.movie_title_text_view);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        String imageUrl = extras.getString("imageUrl");
        movieTitle.setText(title);
        Picasso.with(this).load(imageUrl).into(moviePosterImageView);

    }

}
