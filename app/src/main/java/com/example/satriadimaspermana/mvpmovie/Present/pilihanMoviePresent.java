package com.example.satriadimaspermana.mvpmovie.Present;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.satriadimaspermana.mvpmovie.Model.RootObject;
import com.example.satriadimaspermana.mvpmovie.Interface.pilihanMovieInput;
import com.example.satriadimaspermana.mvpmovie.Interface.pilihanMovieOutput;
import com.example.satriadimaspermana.mvpmovie.Model.pilihanMovieModel;
import com.example.satriadimaspermana.mvpmovie.API.AppController;
import com.example.satriadimaspermana.mvpmovie.API.Const;
import com.example.satriadimaspermana.mvpmovie.View.MyAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class pilihanMoviePresent implements pilihanMovieInput {
    public pilihanMovieOutput output;
    private String tag_json_arry = "jarray_req" ;
    private String TAG = pilihanMoviePresent.class.getSimpleName();
    private MyAdapter adapter = new MyAdapter();

    @Override
    public void doSomething(String strA, String strB) {
        pilihanMovieModel response = new pilihanMovieModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }

    @Override
    public void makeJsonSatu() {
        callApi(Const.URL_API_POPULAR);
    }

    @Override
    public void makeJsonDua() {
        callApi(Const.URL_API_RATING);
    }

    @Override
    public void makeJsontiga() {
        callApi(Const.URL_API_UPCOMMING);
    }

    public void callApi(String url){
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        RootObject rootObject = new Gson().fromJson(response.toString(),RootObject.class);

                        output.displayMovie(rootObject);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req,tag_json_arry);
    }

}