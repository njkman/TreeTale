package com.example.android.treetale;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

/**
 * Created by nj_km on 28/06/2016.
 */
public class StoryAdapter extends ArrayAdapter<Story> {

    // Variables that provides context to the state of the application and a List of Story objects.
    private Context context;
    private List<Story> storyList;

    //constructor for StoryAdapter class
    public StoryAdapter(List<Story> storyList, Context ctx) {
        super();
        this.storyList = storyList;
        this.context = ctx;


    }


    public View getView(int position, View convertView, ViewGroup parent){

        // checks if the convertView is null. If it is will create new view, otherwise resuse already created view
        if (convertView == null)


        return convertView;
    }
}


