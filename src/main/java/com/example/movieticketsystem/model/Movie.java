package com.example.movieticketsystem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private double ticketPrice;

    // **Bổ sung** constructor không tham số:
    public Movie() {}

    // Constructor full-arg vẫn giữ lại nếu cần:
    public Movie(int id, String title, String genre, double ticketPrice) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
    }

    // getters & setters

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getTicketPrice() { return ticketPrice; }

    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setTicketPrice(double price) { this.ticketPrice = price; }
}
