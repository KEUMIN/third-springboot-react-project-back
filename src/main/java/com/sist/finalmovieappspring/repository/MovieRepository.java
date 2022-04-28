package com.sist.finalmovieappspring.repository;

import com.sist.finalmovieappspring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
