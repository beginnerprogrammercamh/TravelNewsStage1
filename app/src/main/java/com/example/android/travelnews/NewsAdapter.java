package com.example.android.travelnews;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    //Set up a News Adapter to display the article info in the list
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        //Creates a view if needed
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        //Get the current position
        News currentNews = getItem(position);

        //Find and set the title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        String title = currentNews.getTitle();
        titleView.setText(title);

        //Find and set the section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        String section = currentNews.getSection();
        sectionView.setText(section);

        //Find and set the date
        //I can't figure out how to format the date. I tried and it doesn't work so it's like this.
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String date = currentNews.getDate();
        dateView.setText(date);

        //There are no authors listed for my news items but I was told to put this in
        TextView authorView = listItemView.findViewById( R.id.author );
        String textAuthor =(currentNews.getAuthor());
        authorView.setText( textAuthor );

        //Return the formatted view
        return listItemView;
    }


}


