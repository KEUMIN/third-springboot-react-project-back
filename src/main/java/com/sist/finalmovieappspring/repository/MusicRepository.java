package com.sist.finalmovieappspring.repository;

import com.sist.finalmovieappspring.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Integer> {
    Music findMusicByNo(Integer no);

    List<Music> findMusicByCommentsContains(@Param("keyword") String keyword);
}
