package com.sist.finalmovieappspring.controller;

import com.sist.finalmovieappspring.dto.MusicDTO;
import com.sist.finalmovieappspring.dto.MusicDetailDTO;
import com.sist.finalmovieappspring.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("music")
    public MusicDTO getMusic(@RequestParam(name = "curPage", defaultValue = "1")Integer curPage) {
        return musicService.getMusicList(curPage);
    }
    @GetMapping("music/{no}")
    public MusicDetailDTO getMusicDetail(@PathVariable("no") int no) {
        return musicService.getMusicDetailDTO(no);
    }
}
