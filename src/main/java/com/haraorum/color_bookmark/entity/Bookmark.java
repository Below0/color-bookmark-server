package com.haraorum.color_bookmark.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
public class Bookmark implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값 자동 주입, DB에 키 생성을 위임함
    private long id;

    @Column(length = 6, unique = true)
    private String color;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public Bookmark(String color) {
        this.color = color;
    }

    public void update(Bookmark bookmark) {
        this.color = bookmark.color;
    }
}
