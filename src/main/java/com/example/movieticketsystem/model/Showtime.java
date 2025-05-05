package com.example.movieticketsystem.model;

import java.time.LocalDateTime;

public class Showtime {
    private final int id;
    private final int movieId;
    private LocalDateTime time;
    private final int totalSeats;

    public Showtime(int id, int movieId, LocalDateTime time, int totalSeats) {
        this.id = id;
        this.movieId = movieId;
        this.time = time;
        this.totalSeats = totalSeats;
    }

    public int getId() { return id; }
    public int getMovieId() { return movieId; }
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
    public int getTotalSeats() { return totalSeats; }
}
