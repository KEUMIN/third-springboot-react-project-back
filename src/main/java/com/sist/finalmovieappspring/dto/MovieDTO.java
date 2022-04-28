package com.sist.finalmovieappspring.dto;

import com.sist.finalmovieappspring.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MovieDTO {
    private List<Movie> movies;
    private Integer totalPages;
    private List<Integer> pages;
}
