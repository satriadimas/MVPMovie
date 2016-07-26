package com.example.satriadimaspermana.mvpmovie.View;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.satriadimaspermana.mvpmovie.Configure.pilihanMovieConfigure;
import com.example.satriadimaspermana.mvpmovie.Interface.pilihanMovieInput;
import com.example.satriadimaspermana.mvpmovie.Interface.pilihanMovieOutput;
import com.example.satriadimaspermana.mvpmovie.Model.Result;
import com.example.satriadimaspermana.mvpmovie.Model.RootObject;
import com.example.satriadimaspermana.mvpmovie.Model.pilihanMovieModel;
import com.example.satriadimaspermana.mvpmovie.R;

import java.util.ArrayList;
import java.util.List;

public class pilihanMovie extends AppCompatActivity implements pilihanMovieOutput {

    public pilihanMovieInput input;
    private MyAdapter adapter = new MyAdapter();
    private List<Result> data = new ArrayList<>();
    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan_movie);
        pilihanMovieConfigure.getInstance().config(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new MyAdapter();
        rec  = (RecyclerView) findViewById(R.id.rec);
        rec.setLayoutManager(new GridLayoutManager(pilihanMovie.this, 2));
        rec.setAdapter(adapter);

        input.makeJsonSatu();

        doSomething();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mostpopular:
                input.makeJsonSatu();
                break;
            case R.id.rated:
                input.makeJsonDua();
                break;
            case R.id.upcomming:
                input.makeJsontiga();
                break;
            default:
        }

        return false;
    }

    private void doSomething() {
        input.doSomething("this", "input");
    }

    @Override
    public void displaySomething(pilihanMovieModel response) {
        Log.d("RESULT", "RESULT");
    }

    @Override
    public void displayMovie(RootObject result) {
        adapter.removeAll(result.results);
        adapter.addAll(result.results);
        adapter.notifyDataSetChanged();

    }

}
