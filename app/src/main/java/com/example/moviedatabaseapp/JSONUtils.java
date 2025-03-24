package com.example.moviedatabaseapp;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONUtils {
    public static List<Movie> loadMovies(Context context) {
        List<Movie> movies = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open("movies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String jsonStr = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String title = obj.optString("title", "No Title");
                int year = obj.optInt("year", 0);
                String genre = obj.optString("genre", "Unknown");
                int posterResId = obj.optInt("posterResId", R.drawable.placeholder);

                movies.add(new Movie(title, year, genre, posterResId));
            }
        } catch (IOException e) {
            Log.e("JSONUtils", "File not found or read error: " + e.getMessage());
        } catch (JSONException e) {
            Log.e("JSONUtils", "JSON parsing error: " + e.getMessage());
        }
        return movies;
    }
}
