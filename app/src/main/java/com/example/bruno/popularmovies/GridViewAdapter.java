package com.example.bruno.popularmovies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bruno.popularmovies.pojo.ImageItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Bruno on 11/19/2015.
 */
public class GridViewAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.text);
            ImageView imageView = (ImageView) row.findViewById(R.id.movie_poster_image_view);
            ImageItem item = (ImageItem) data.get(position);
            // Picasso
            Picasso.with(getContext()).load(item.getUrl()).into(imageView);
            holder.image = imageView;
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ImageItem item = (ImageItem) data.get(position);
        holder.imageTitle.setText(item.getTitle());
        return row;
    }

    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }
}
