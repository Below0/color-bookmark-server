package com.haraorum.color_bookmark.service;

import com.haraorum.color_bookmark.entity.Bookmark;
import com.haraorum.color_bookmark.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    public List<Bookmark> findAll() {
        List<Bookmark> bookmarks = new ArrayList<>();
        bookmarkRepository.findAll().forEach(e -> bookmarks.add(e));
        return bookmarks;
    }

    public Optional<Bookmark> findByColor(String color) {
        Optional<Bookmark> bookmark = bookmarkRepository.findBookmarkByColor(color);
        return bookmark;
    }

    public String deleteByColor(String color) {
        bookmarkRepository.deleteBookmarkByColor(color);
        return color;
    }

    public Bookmark save(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
        return bookmark;
    }
}
