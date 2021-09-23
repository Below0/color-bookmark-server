package com.haraorum.color_bookmark.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
public class Bookmark implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값 자동 주입, DB에 키 생성을 위임함
    private long id;

    @Column
    private String name;

    @Column(length = 6)
    private String color;

    @Builder
    public Bookmark(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void update(Bookmark bookmark) {
        this.name = bookmark.name;
        this.color = bookmark.color;
    }
}
