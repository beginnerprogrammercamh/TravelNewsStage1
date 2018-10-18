package com.example.android.travelnews;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

//Sets up the loader
public class NewsLoader extends AsyncTaskLoader<List<News>> {


    private static final String LOG_TAG = NewsLoader.class.getName();

    //Defines the url
    private String mUrl;

    //Takes in the url as input
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    //Sets up the network request on a background thread
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news articles.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}