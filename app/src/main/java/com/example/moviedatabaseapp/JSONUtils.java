package com.example.moviedatabaseapp;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONUtils {
    public static List<Movie> loadMovies(Context context) {
        List<Movie> movies = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open("movies.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String jsonStr = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(jsonStr);

            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String title = obj.optString("title", "");
                    int year = parseYear(obj.opt("year"));
                    String genre = obj.optString("genre", "Unknown");
                    String posterName = obj.optString("poster", "");
                    int posterResId = context.getResources().getIdentifier(
                            posterName, "drawable", context.getPackageName()
                    );
                    movies.add(new Movie(title, year, genre, posterResId));
                } catch (JSONException e) {
                    Log.e("JSONUtils", "Error parsing item " + i, e);
                }
            }
        } catch (IOException | JSONException e) {
            Log.e("JSONUtils", "Failed to load movies", e);
        }
        return movies;
    }

    private static int parseYear(Object yearObj) {
        try {
            if (yearObj instanceof Integer) return (int) yearObj;
            if (yearObj instanceof String) {
                String str = ((String) yearObj).replaceAll("[^0-9]", "");
                return Integer.parseInt(str);
            }
        } catch (Exception e) {
            Log.e("JSONUtils", "Invalid year format: " + yearObj);
        }
        return 1888;
    }
}