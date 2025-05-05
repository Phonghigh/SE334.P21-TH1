package com.example.movieticketsystem.controller;

import com.example.movieticketsystem.repository.MovieRepository;
import com.example.movieticketsystem.repository.ShowTimeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MovieRepository movieRepo = new MovieRepository();
    private final ShowTimeRepository showRepo = new ShowTimeRepository();

    @GetMapping("/movies")
    public String movies(Model m) {
        m.addAttribute("movies", movieRepo.findAll());
        return "admin/movies";
    }

    @PostMapping("/movies")
    public String addMovie(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam double price) {
        movieRepo.save(title, genre, price);
        return "redirect:/admin/movies";
    }

    @PostMapping("/movies/delete")
    public String deleteMovie(@RequestParam int id) {
        movieRepo.delete(id);
        return "redirect:/admin/movies";
    }

    @GetMapping("/showtimes")
    public String times(Model m) {
        m.addAttribute("showtimes", showRepo.findAll());
        m.addAttribute("movies", movieRepo.findAll());
        return "admin/showtimes";
    }

    @PostMapping("/showtimes")
    public String addTime(@RequestParam int movieId,
                          @RequestParam String time,
                          @RequestParam int seats) {
        showRepo.save(movieId, java.time.LocalDateTime.parse(time), seats);
        return "redirect:/admin/showtimes";
    }

    @PostMapping("/showtimes/delete")
    public String deleteTime(@RequestParam int id) {
        showRepo.delete(id);
        return "redirect:/admin/showtimes";
    }
}
