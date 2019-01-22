package com.example.akshay.downlaodingwebcontent;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    //https://www.google.com/imgres?imgurl=https%3A%2F%2Fpi.tedcdn.com%2Fr%2Ftalkstar-assets.s3.amazonaws.com%2Fproduction%2Fplaylists%2Fplaylist_251%2Fhated_math_1200x627.jpg%3Fc%3D1050%252C550%26w%3D1050&imgrefurl=https%3A%2F%2Fwww.ted.com%2Ftopics%2Fmath&docid=B9P-a9NuPKYXcM&tbnid=QnSowEamUUf8VM%3A&vet=10ahUKEwi11oeX8IHgAhUOcCsKHd_CAgUQMwhrKAQwBA..i&w=1050&h=549&bih=657&biw=1366&q=math&ved=0ahUKEwi11oeX8IHgAhUOcCsKHd_CAgUQMwhrKAQwBA&iact=mrc&uact=8
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    public void Change(View view) {
        asynctask task=new asynctask();
        Bitmap bitmap;
        try {
            bitmap=task.execute("https://www.freepik.com/free-vector/realistic-set-of-colorful-powder-clouds-or-explosions-isolated-on-transparent-background_3685328.htm").get();

             imageView.setImageBitmap(bitmap);


        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("click", "newimage");
    }


    @SuppressLint("StaticFieldLeak")
    public class asynctask extends AsyncTask<String,Void,Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... urls) {
            try {

                URL url =new URL(urls[0]);
                HttpURLConnection connection =(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream inputStream =connection.getInputStream();
                Bitmap abitmap =BitmapFactory.decodeStream(inputStream);
                return abitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();
            }

            return null;
        }
    }
}

