package com.example.bruno.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.bruno.popularmovies.pojo.ImageItem;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private GridView gridView;
    private GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(R.drawable.hiperline_logo);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);


        gridView = (GridView) findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageItem imageItem = (ImageItem) gridViewAdapter.getItem(position);
                String title = imageItem.getTitle();
                String imageUrl = imageItem.getUrl();
                Intent detailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                detailActivity.putExtra("title", title);
                detailActivity.putExtra("imageUrl", imageUrl);
                startActivity(detailActivity);
            }
        });


    }


    private ArrayList<ImageItem> getData(){

        ArrayList<ImageItem> imageItemArrayList = new ArrayList<>();

        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "Straight Outta Compton", "https://upload.wikimedia.org/wikipedia/en/7/7a/Straight_Outta_Compton_poster.jpg"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "Interestelar", "http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/interstellar3.jpg"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "Spectre", "http://t3.gstatic.com/images?q=tbn:ANd9GcQcjheOnBb_WFU5yuYLnUYWjfr33KzdFx1PCNGVhgM4-89otmi9"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "Creed", "http://t3.gstatic.com/images?q=tbn:ANd9GcRkYxKi3vFoga2SrzgQLaHP55yErfQcCSfEK2lGGu7ToBBzSJiQ"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "Bridge of Spies", "http://t0.gstatic.com/images?q=tbn:ANd9GcTdLYClfLChMefry31qTum4fxmN2RdTeS7pLDFRlmY-ECM3DkLK"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "By the Sea", "http://t2.gstatic.com/images?q=tbn:ANd9GcT4MdKa-LwzuKJhFlNzQ9BINZBVBzivZDJG1E-ihbeBWhhus0sH"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "The Walk", "http://t0.gstatic.com/images?q=tbn:ANd9GcRt-NNLdpEC9_CiruBhNHk3sPg39TJBn1DnuXM5XIxdOaVekKyx"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "No Escape", "http://t1.gstatic.com/images?q=tbn:ANd9GcSA5oaNeIpuvXKdK0B_zXteGhNBMuOtdlpVXDI3hGOTmZv507Wm"));
        imageItemArrayList.add(new ImageItem(new ImageView(this),
                "Black Mass", "http://t2.gstatic.com/images?q=tbn:ANd9GcSK3LiV9aI4uMtI91ZJjDM15AazxWB5uKkxV8D04NARj2sJdBOG"));


        return imageItemArrayList;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*private class BitmapFromURL extends AsyncTask<String, Void, Bitmap[]> {

        @Override
        protected Bitmap[] doInBackground(String... params) {

            ArrayList<Bitmap> bitmapArray = new ArrayList<>();

            for (String src : params) {
                try {
                    URL url = new URL(src);
                    Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    bitmapArray.add(image);
                } catch (IOException e) {
                    Log.d("Error bitmap from URL", e.getMessage());
                }
            }



            return (Bitmap[]) bitmapArray.toArray();
        }

        @Override
        protected void onPostExecute(Bitmap[] bitmaps) {
            super.onPostExecute(bitmaps);
            if(bitmaps != null){
                gridViewAdapter.clear();
            }
        }
    }*/
}
