package com.example.moviedatabaseapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieList = JSONUtils.loadMovies(this);

        if (movieList.isEmpty()) {
            Toast.makeText(this, "Unable to load movie data, please check JSON file format or content", Toast.LENGTH_LONG).show();
        }

        adapter = new MovieAdapter(this, movieList);
        recyclerView.setAdapter(adapter);
    }
}
