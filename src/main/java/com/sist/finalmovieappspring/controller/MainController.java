package com.sist.finalmovieappspring.controller;

import com.sist.finalmovieappspring.dto.MusicDTO;
import com.sist.finalmovieappspring.entity.Music;
import com.sist.finalmovieappspring.repository.MusicRepository;
import com.sist.finalmovieappspring.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private MusicService musicService;
    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/main")
    public MusicDTO getMusicsByKeyword(@RequestParam(name = "keyword", defaultValue = "봄")String keyword) {
        return musicService.getMusicDTOByKeyword(keyword);
//        return musicRepository.findMusicByCommentsContains(keyword);
    }
}
