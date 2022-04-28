package com.sist.finalmovieappspring.dto;

import com.sist.finalmovieappspring.entity.Music;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MusicDTO {
    private List<Music> musics;
    private Integer totalPages;
    private List<Integer> pages;
}
