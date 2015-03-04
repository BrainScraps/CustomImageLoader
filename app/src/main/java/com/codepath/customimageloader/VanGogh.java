package com.codepath.customimageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class VanGogh {
    public static void load(String imgUrl, ImageView v){
       //1. Check the internet connection
        //2. Make a network request to the url
        //3. Get response
        //4. Turn them into a Bitmap
        //1. (1.0) check the cache

        new VanGoghTask(v).execute(imgUrl);
        // 1. Declare a URL Connection

    }
    public static class VanGoghTask extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public VanGoghTask(ImageView imageView) {
            this.imageView = imageView;

        }

        // Creates a thread, passes the input, runs and returns the result
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // 2. Open InputStream to connection
                conn.connect();
                InputStream in = conn.getInputStream();
                // 3. Download and decode the bitmap using BitmapFactory
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                in.close();
                return bitmap;
                // 4. Insert into an ImageView
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        // RUNS on the UIthread
        // It wants to make changes to the UI here
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            // insert the bitmap into the imageview here
            imageView.setImageBitmap(bitmap);
        }
    }

}
