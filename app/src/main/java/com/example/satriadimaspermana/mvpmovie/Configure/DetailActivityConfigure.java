package com.example.satriadimaspermana.mvpmovie.Configure;

import com.example.satriadimaspermana.mvpmovie.Present.DetailActivityPresent;
import com.example.satriadimaspermana.mvpmovie.View.DetailActivity;

/**
 * Created by gits on Configurator
 */
public class DetailActivityConfigure {
    private static DetailActivityConfigure ourInstance = new DetailActivityConfigure();

    private DetailActivityConfigure() {
    }

    public static DetailActivityConfigure getInstance() {
        return ourInstance;
    }

    public void config(DetailActivity activity) {
        DetailActivityPresent present = new DetailActivityPresent();
        present.output = activity;
        activity.input = present;
    }
}
