package com.example.movieticketsystem.service;

import com.example.movieticketsystem.model.Seat;
import java.util.concurrent.locks.ReentrantLock;

public class TicketService {
    private final ReentrantLock lock = new ReentrantLock();

    public boolean reserveSeat(Seat seat) {
        lock.lock();
        try {
            return seat.reserve();
        } finally {
            lock.unlock();
        }
    }

    public boolean cancelSeat(Seat seat) {
        lock.lock();
        try {
            return seat.cancel();
        } finally {
            lock.unlock();
        }
    }
}
