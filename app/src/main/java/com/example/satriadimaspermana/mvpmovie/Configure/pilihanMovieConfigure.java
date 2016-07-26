package com.example.satriadimaspermana.mvpmovie.Configure;

import com.example.satriadimaspermana.mvpmovie.View.pilihanMovie;
import com.example.satriadimaspermana.mvpmovie.Present.pilihanMoviePresent;

/**
 * Created by gits on Configurator
 */
public class pilihanMovieConfigure {
    private static pilihanMovieConfigure ourInstance = new pilihanMovieConfigure();

    private pilihanMovieConfigure() {
    }

    public static pilihanMovieConfigure getInstance() {
        return ourInstance;
    }

    public void config(pilihanMovie activity) {
        pilihanMoviePresent present = new pilihanMoviePresent();
        present.output = activity;
        activity.input = present;
    }
}
