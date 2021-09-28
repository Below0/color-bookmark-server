package com.haraorum.color_bookmark.repository;

import com.haraorum.color_bookmark.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findBookmarkByColor(String color);

    @Transactional
    Optional<Bookmark> deleteBookmarkByColor(String color);
}
