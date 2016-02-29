package com.group26.sax;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by crosario on 2/22/2016.
 */
public class GetPersonsAsyncTask extends AsyncTask<String, Void, ArrayList<Person>> {

    @Override
    protected ArrayList<Person> doInBackground(String... params) {

        try{
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int statusCode = connection.getResponseCode();

            if(statusCode == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = reader.readLine();

                while(line != null){
                    sb.append(line);
                    line = reader.readLine();
                }
                try {
                    return PersonsUtil.PersonsJSONParser.parsePersons(sb.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("demo", sb.toString());
                //InputStream in = connection.getInputStream();
                //return PersonsUtil.PersonsSAXParser.parsePerson(in);
                //return PersonsUtil.PersonsPullParser.parsePersons(in);
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } //catch(XmlPullParserException e){
//            e.printStackTrace();
//        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> persons) {
        super.onPostExecute(persons);

        if(persons != null){
            for(Person p: persons){
                Log.d("demo", String.valueOf(p.getId()));
                Log.d("demo", String.valueOf(p.getAge()));
                Log.d("demo", p.getDepartment());
                Log.d("demo", p.getName());
            }
            Log.d("demo", persons.toString());
        }

    }
}
