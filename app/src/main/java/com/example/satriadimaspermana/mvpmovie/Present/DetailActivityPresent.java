package com.example.satriadimaspermana.mvpmovie.Present;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.satriadimaspermana.mvpmovie.API.AppController;
import com.example.satriadimaspermana.mvpmovie.Interface.DetailActivityInput;
import com.example.satriadimaspermana.mvpmovie.Interface.DetailActivityOutput;
import com.example.satriadimaspermana.mvpmovie.Model.DetailActivityModel;
import com.example.satriadimaspermana.mvpmovie.Model.Result;
import com.example.satriadimaspermana.mvpmovie.Model.ResultReviews;
import com.example.satriadimaspermana.mvpmovie.Model.Reviews;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class DetailActivityPresent implements DetailActivityInput {
    public DetailActivityOutput output;
    public final static String KEY_MEMBER = "keymember";
    private Result object;
    private String tag_json_arry = "jarray_req" ;
    private String TAG = DetailActivityPresent.class.getSimpleName();

    @Override
    public void doSomething(String strA, String strB) {
        DetailActivityModel response = new DetailActivityModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }


    @Override
    public void makeJsonReviews(int aidi) {
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                "http://api.themoviedb.org/3/movie/"+aidi+"/reviews?api_key=1b2f29d43bf2e4f3142530bc6929d341", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Reviews rootObject = new Gson().fromJson(response.toString(),Reviews.class);
                        output.displayReviews(rootObject);

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