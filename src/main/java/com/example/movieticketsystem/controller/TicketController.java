package com.example.movieticketsystem.controller;

import com.example.movieticketsystem.model.Seat;
import com.example.movieticketsystem.model.Showtime;
import com.example.movieticketsystem.repository.SeatRepository;
import com.example.movieticketsystem.repository.ShowTimeRepository;
import com.example.movieticketsystem.service.PaymentService;
import com.example.movieticketsystem.service.TicketService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {
    private final ShowTimeRepository showRepo = new ShowTimeRepository();
    private SeatRepository seatRepo;
    private final TicketService ticketService = new TicketService();
    private final PaymentService paymentService = new PaymentService();

    @GetMapping("/book")
    public String showShowtimes(Model model) {
    List<Showtime> showtimes = showRepo.findAll();
    model.addAttribute("showtimes", showtimes);
    return "book/showtimes"; // trỏ đúng file showtimes.html
}
    public String chooseShow(Model m) {
        m.addAttribute("showtimes", showRepo.findAll());
        return "book/showtimes";
    }

    @GetMapping("/book/{showId}")
    public String chooseSeat(@PathVariable int showId, Model m) {
        Showtime st = showRepo.findById(showId);
        seatRepo = new SeatRepository(st.getTotalSeats());
        m.addAttribute("showtime", st);
        m.addAttribute("seats", seatRepo.getSeats());
        return "book/seats";
    }

    @PostMapping("/book/{showId}")
    public String reserve(@PathVariable int showId,
                            @RequestParam int seatNumber,
                            Model m) {
        Seat seat = seatRepo.getSeat(seatNumber);
        boolean ok = ticketService.reserveSeat(seat);
        if (ok) {
            double amount = 100000;
            boolean paid = paymentService.processPayment(0, amount);
            m.addAttribute("message", paid ? "Đặt & thanh toán thành công" : "Thanh toán thất bại");
        } else {
            m.addAttribute("message", "Ghế đã được đặt");
        }
        m.addAttribute("seats", seatRepo.getSeats());
        return "book/seats";
    }
}
