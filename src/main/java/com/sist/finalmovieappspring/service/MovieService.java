package com.sist.finalmovieappspring.service;

import com.sist.finalmovieappspring.dto.MovieDTO;
import com.sist.finalmovieappspring.entity.Movie;
import com.sist.finalmovieappspring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    private final static int POSTS_PER_PAGE = 12;
    private final static int PAGES_PER_BLOCK = 5;


    public MovieDTO getMovieList(Integer curPage) {
        PageRequest pageRequest = PageRequest.of((curPage-1), POSTS_PER_PAGE);
        Page<Movie> movies = movieRepository.findAll(pageRequest);

        int firstPage = (((curPage - 1) / PAGES_PER_BLOCK) * PAGES_PER_BLOCK) + 1;
        int endPage = (((curPage - 1) / PAGES_PER_BLOCK) * PAGES_PER_BLOCK) + PAGES_PER_BLOCK;
        int totalPages = movies.getTotalPages();

        endPage = endPage > totalPages ? totalPages : endPage;

        List<Integer> pages = IntStream.rangeClosed(firstPage, endPage).boxed().collect(Collectors.toList());

        return getMovieDTO(movies, pages, totalPages);
    }

    private MovieDTO getMovieDTO(Page<Movie> movies, List<Integer> pages, int totalPages) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovies(movies.getContent());
        movieDTO.setPages(pages);
        movieDTO.setTotalPages(totalPages);
        return movieDTO;
    }
}
