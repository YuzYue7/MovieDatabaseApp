package com.example.moviedatabaseapp;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Movie> movieList = JSONUtils.loadMovies(this);
        if (movieList.isEmpty()) {
            Toast.makeText(this, "No movies found!", Toast.LENGTH_SHORT).show();
        } else {
            recyclerView.setAdapter(new MovieAdapter(this, movieList));
        }
    }
}