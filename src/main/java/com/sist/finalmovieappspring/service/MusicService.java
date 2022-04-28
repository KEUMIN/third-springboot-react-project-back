package com.sist.finalmovieappspring.service;

import com.sist.finalmovieappspring.dto.MusicDTO;
import com.sist.finalmovieappspring.dto.MusicDetailDTO;
import com.sist.finalmovieappspring.entity.Music;
import com.sist.finalmovieappspring.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    private final static int POSTS_PER_PAGE = 20;
    private final static int PAGES_PER_BLOCK = 5;


    public MusicDTO getMusicList(Integer curPage) {
        PageRequest pageRequest = PageRequest.of((curPage-1), POSTS_PER_PAGE);
        Page<Music> musicPage = musicRepository.findAll(pageRequest);

        int firstPage = (((curPage - 1) / PAGES_PER_BLOCK) * PAGES_PER_BLOCK) + 1;
        int endPage = (((curPage - 1) / PAGES_PER_BLOCK) * PAGES_PER_BLOCK) + PAGES_PER_BLOCK;
        int totalPages = musicPage.getTotalPages();

        endPage = endPage > totalPages ? totalPages : endPage;

        List<Integer> pages = IntStream.rangeClosed(firstPage, endPage).boxed().collect(Collectors.toList());

        return getMusicDTO(musicPage.getContent(), pages, totalPages);
    }

    public MusicDetailDTO getMusicDetailDTO(int no) {
        MusicDetailDTO musicDetailDTO = new MusicDetailDTO();
        musicDetailDTO.buildMusicDTO(musicRepository.findMusicByNo(no));
        return musicDetailDTO;
    }

    public MusicDTO getMusicDTOByKeyword(String keyword) {
        List<Integer> pages = new ArrayList<>();
        return getMusicDTO(musicRepository.findMusicByCommentsContains(keyword), pages, 0);
    }
    private MusicDTO getMusicDTO(List<Music> musics, List<Integer> pages, int totalPages) {
        MusicDTO musicDTO = new MusicDTO();
        musicDTO.setMusics(musics);
        musicDTO.setPages(pages);
        musicDTO.setTotalPages(totalPages);
        return musicDTO;
    }

}
