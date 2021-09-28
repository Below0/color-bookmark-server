package com.haraorum.color_bookmark.controller;

import com.haraorum.color_bookmark.entity.Bookmark;
import com.haraorum.color_bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/bookmark")
@RequiredArgsConstructor
@RestController
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @GetMapping
    public ResponseEntity<List<Bookmark>> getAllBookmarks() {
        List<Bookmark> bookmarks = bookmarkService.findAll();
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }

    @GetMapping(value = "/{color}")
    public ResponseEntity<Optional<Bookmark>> getBookmark(@PathVariable String color) {
        return new ResponseEntity<>(bookmarkService.findByColor(color), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
        return new ResponseEntity<>(bookmarkService.save(bookmark), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{color}")
    public ResponseEntity<String> deleteBookmark(@PathVariable String color) {
        return new ResponseEntity<>(bookmarkService.deleteByColor(color), HttpStatus.OK);
    }
}
