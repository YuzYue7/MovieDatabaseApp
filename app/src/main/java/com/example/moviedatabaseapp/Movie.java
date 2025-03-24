package com.example.moviedatabaseapp;

public class Movie {
    private final String title;
    private final int year;
    private final String genre;
    private final int posterResId;

    public Movie(String title, int year, String genre, int posterResId) {
        this.title = (title == null || title.isEmpty()) ? "Unknown Title" : title;
        this.year = Math.max(year, 1888);
        this.genre = (genre == null || genre.isEmpty()) ? "Unknown" : genre;
        this.posterResId = (posterResId == 0) ? R.drawable.placeholder : posterResId;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }
    public int getPosterResId() { return posterResId; }
}