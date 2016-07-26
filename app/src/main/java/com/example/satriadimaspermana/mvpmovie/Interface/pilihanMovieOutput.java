package com.example.satriadimaspermana.mvpmovie.Interface;

import com.example.satriadimaspermana.mvpmovie.Model.RootObject;
import com.example.satriadimaspermana.mvpmovie.Model.pilihanMovieModel;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface pilihanMovieOutput {
    void displaySomething(pilihanMovieModel response);
    void displayMovie(RootObject result);
}