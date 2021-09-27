package com.haraorum.color_bookmark.controller;

import com.haraorum.color_bookmark.entity.Bookmark;
import com.haraorum.color_bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
        return new ResponseEntity<>(bookmarkService.save(bookmark), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteBookmark(@PathVariable Long id) {
        return new ResponseEntity<>(bookmarkService.deleteById(id), HttpStatus.OK);
    }
}
