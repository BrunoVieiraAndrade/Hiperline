package com.example.bruno.popularmovies.pojo;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Bruno on 11/19/2015.
 */
public class ImageItem {
    private ImageView image;
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public ImageItem() {
    }

    public ImageItem(ImageView imageView, String title, String url) {
        super();
        this.image = imageView;
        this.title = title;
        this.url = url;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
