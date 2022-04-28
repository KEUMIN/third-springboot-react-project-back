package com.sist.finalmovieappspring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mno;
    @Column
    private Integer cno;
    @Column
    private String title,time,grade,reserve,genre,regdate,director,
            actor,showUser,poster,story,mkey;
}
