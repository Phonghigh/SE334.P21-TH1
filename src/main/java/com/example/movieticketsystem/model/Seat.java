package com.example.movieticketsystem.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class Seat {
    private final int seatNumber;
    private final AtomicBoolean available = new AtomicBoolean(true);

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() { return seatNumber; }
    public boolean isAvailable() { return available.get(); }

    public boolean reserve() {
        return available.compareAndSet(true, false);
    }

    public boolean cancel() {
        return available.compareAndSet(false, true);
    }
}
