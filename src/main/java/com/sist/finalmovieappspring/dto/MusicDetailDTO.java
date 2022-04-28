package com.sist.finalmovieappspring.dto;

import com.sist.finalmovieappspring.entity.Music;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class MusicDetailDTO {
    private int no;
    private Integer cno, idcrement;
    private String title, singer, album, state, poster, mkey;
    private List<Comment> comments;

    public void buildMusicDTO(Music music) {
        this.no = music.getNo();
        this.cno = music.getCno();
        this.idcrement = music.getIdcrement();
        this.title = music.getTitle();
        this.singer = music.getSinger();
        this.album = music.getAlbum();
        this.state = music.getState();
        this.poster = music.getPoster();
        this.mkey = music.getMkey();
        this.comments = getComments(music.getComments());
    }
    public List<Comment> getComments(String rawComment) {
        if (rawComment == null || rawComment == " ") return null;
        String[] commentArr = rawComment.split("/");
        return Arrays.stream(commentArr)
                .map(c -> new Comment(c.split("%")[0], Integer.parseInt(c.split("%")[1])))
                .collect(Collectors.toList());
    }
}
