package com.example.movieticketsystem.repository;

import com.example.movieticketsystem.model.Showtime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ShowTimeRepository {
    private final List<Showtime> list = new CopyOnWriteArrayList<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public List<Showtime> findAll() {
        return list;
    }

    public Showtime findById(int id) {
        return list.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public Showtime save(int movieId, java.time.LocalDateTime time, int seats) {
        Showtime s = new Showtime(seq.incrementAndGet(), movieId, time, seats);
        list.add(s);
        return s;
    }

    public boolean delete(int id) {
        return list.removeIf(s -> s.getId() == id);
    }

    public boolean updateTime(int id, java.time.LocalDateTime time) {
        Showtime s = findById(id);
        if (s == null) return false;
        s.setTime(time);
        return true;
    }
}
