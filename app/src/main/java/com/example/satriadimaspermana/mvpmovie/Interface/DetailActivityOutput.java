package com.example.satriadimaspermana.mvpmovie.Interface;

import com.example.satriadimaspermana.mvpmovie.Model.DetailActivityModel;
import com.example.satriadimaspermana.mvpmovie.Model.Result;
import com.example.satriadimaspermana.mvpmovie.Model.Reviews;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface DetailActivityOutput {
    void displaySomething(DetailActivityModel response);
    void displayReviews(Reviews review);
}