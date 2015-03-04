package com.codepath.customimageloader;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class PhotoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        // README
        // 1. Download an image from a URL and put it into an imageview
        // 2. Download, resize it to a width and put into an ImageView
        // VanGogh.load("http://", imageView);
        // VanGogh.load("http", 200,300, imageView);
        // VanGogh.load("htp", 200, 300, new VanGoghCallback(){
        //   public void onSuccess(Bitmap bitmap){
        //     imageView.setImageBitmap(bitmap);
        //   }
        // });
        String url = "http://i.imgur.com/tGbaZCY.jpg";
        ImageView ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        VanGogh.load(url, ivPhoto);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo, menu);
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
}
