package com.example.movieticketsystem.repository;

import com.example.movieticketsystem.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MovieRepository {
    private final List<Movie> movies = new CopyOnWriteArrayList<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public List<Movie> findAll() {
        return movies;
    }

    public Movie findById(int id) {
        return movies.stream()
                     .filter(m -> m.getId() == id)
                     .findFirst()
                     .orElse(null);
    }

    public Movie save(String title, String genre, double price) {
        Movie m = new Movie(seq.incrementAndGet(), title, genre, price);
        movies.add(m);
        return m;
    }

    public boolean delete(int id) {
        return movies.removeIf(m -> m.getId() == id);
    }

    public boolean update(int id, String title, String genre, double price) {
        Movie m = findById(id);
        if (m == null) return false;
        m.setTitle(title);
        m.setGenre(genre);
        m.setTicketPrice(price);
        return true;
    }
}
