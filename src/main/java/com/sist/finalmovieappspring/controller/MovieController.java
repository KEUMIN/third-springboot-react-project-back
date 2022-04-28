package com.sist.finalmovieappspring.controller;

import com.sist.finalmovieappspring.dto.MovieDTO;
import com.sist.finalmovieappspring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("movie")
    public MovieDTO getMovie(@RequestParam(name = "curPage", defaultValue = "1")Integer curPage) {
        return movieService.getMovieList(curPage);
    }
}
