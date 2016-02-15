package com.example.carlos.myapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isConnectedOnline()){
                    Toast.makeText(MainActivity.this, "Connected to network", Toast.LENGTH_LONG).show();
                    //new GetData().execute("http://rss.cnn.com/rss/cnn_tech.rss");
                    //new GetImage().execute("https://www.google.com/logos/doodles/2016/valentines-day-2016-5699846440747008-5096695956242432-ror.gif");

                    RequestParams params = new RequestParams("GET", "http://dev.theappsdr.com/lectures/params.php");
                    params.addParam("key1", "Carlos");
                    params.addParam("key2", "Alicia");
                    params.addParam("key3", "Sammy");
                    params.addParam("key4", "WalkingDead");
                    new GetDataWithParams().execute(params);
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed to connect to network", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private class GetDataWithParams extends AsyncTask<RequestParams, Void, String>{

        @Override
        protected String doInBackground(RequestParams... params) {

            BufferedReader bufferedReader = null;
            try {
                HttpURLConnection connection = params[0].setupConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                //Bitmap image = BitmapFactory.decodeStream(connection.getInputStream()); // use this code to return an image
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    sb.append(line + System.getProperty("line.separator"));
                }

                return sb.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(bufferedReader != null){
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return "";
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            if (result != null && result != ""){
                Log.d("demo", result);
            }
            else {
                Log.d("demo", "no data received");
            }
        }
    }

    private class GetImage extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                Bitmap image = BitmapFactory.decodeStream(con.getInputStream());
                return image;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch(IOException io){
                io.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null){
                ImageView imageview = (ImageView)findViewById(R.id.imageView);
                imageview.setImageBitmap(bitmap);
            }
        }
    }

    // http://rss.cnn.com/rss/cnn_tech.rss
    private class GetData extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            BufferedReader bufferedReader = null;
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");

                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                //Bitmap image = BitmapFactory.decodeStream(connection.getInputStream()); // use this code to return an image
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    sb.append(line + System.getProperty("line.separator"));
                }

                return sb.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException io){
                io.printStackTrace();
            }
            finally {
                if(bufferedReader != null){
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return "";
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            if (result != null && result != ""){
                Log.d("demo", result);
            }
            else {
                Log.d("demo", "no data received");
            }
        }
    }



    // Method to check if device is connected to network
    private boolean isConnectedOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // We can use networkInfo.getType() to figure out what kind of network the device is connected to (wifi, ethernet, bluetooth, etc)
        if(networkInfo != null && networkInfo.isConnected()){
            return  true;
        }
        return false;
    }
}
