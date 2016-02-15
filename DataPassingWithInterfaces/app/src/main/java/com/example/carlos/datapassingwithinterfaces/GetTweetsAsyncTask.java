package com.example.carlos.datapassingwithinterfaces;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import java.util.LinkedList;

/**
 * Created by Carlos on 2/15/2016.
 */
public class GetTweetsAsyncTask extends AsyncTask<String, Void, LinkedList<String>> {

    IData activity;

    public GetTweetsAsyncTask(IData activity){
        this.activity = activity;
    }

    @Override
    protected LinkedList<String> doInBackground(String... params) {
        LinkedList<String> tweets = new LinkedList<String>();
        tweets.add("Tweet 0");
        tweets.add("Tweet 1");
        tweets.add("Tweet 2");
        tweets.add("Tweet 3");
        return tweets;
    }

    @Override
    protected void onPostExecute(LinkedList<String> strings) {
        super.onPostExecute(strings);
        activity.setupData(strings);

    }

    public interface IData {
        void setupData(LinkedList<String> strings);
        Context getContext();
    }

}
