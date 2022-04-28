package com.sist.finalmovieappspring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "music")
@Getter
@Setter
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    @Column
    private Integer cno,idcrement;
    @Column
    private String title,singer,album,state,poster,mkey,comments;
}

