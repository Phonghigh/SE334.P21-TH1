package com.example.movieticketsystem.repository;

import com.example.movieticketsystem.model.Seat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SeatRepository {
    private final List<Seat> seats;

    public SeatRepository(int n) {
        seats = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= n; i++) {
            seats.add(new Seat(i));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat getSeat(int number) {
        return seats.get(number - 1);
    }
}
