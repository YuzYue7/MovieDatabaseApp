package com.example.moviedatabaseapp;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private int posterResId;

    public Movie(String title, int year, String genre, int posterResId) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be null or empty");
        }
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResId = posterResId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getPosterResId() {
        return posterResId;
    }
}
