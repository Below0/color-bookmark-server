package com.haraorum.color_bookmark.controller;

import com.haraorum.color_bookmark.entity.Bookmark;
import com.haraorum.color_bookmark.message.Message;
import com.haraorum.color_bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/bookmark")
@RequiredArgsConstructor
@RestController
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @GetMapping
    public ResponseEntity<Message> getAllBookmarks() {
        List<Bookmark> bookmarks = bookmarkService.findAll();

        Message message = Message.builder()
                .status(200)
                .data(bookmarks)
                .build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/{color}")
    public ResponseEntity<Message> getBookmark(@PathVariable String color) {
        Message message = Message.builder()
                .status(200)
                .data(bookmarkService.findByColor(color))
                .build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Message> createBookmark(@RequestBody Bookmark bookmark) {
        Bookmark responseBookmark;

        try {
            responseBookmark = bookmarkService.save(bookmark);
        } catch (DataIntegrityViolationException e) {
            Message message = Message.builder()
                    .status(-1)
                    .message("해당 색상코드는 이미 존재합니다.")
                    .build();
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        Message message = Message.builder()
                .status(200)
                .data(responseBookmark)
                .build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{color}")
    public ResponseEntity<Message> deleteBookmark(@PathVariable String color) {
        Message message = Message.builder()
                .status(200)
                .data(bookmarkService.deleteByColor(color))
                .message("제거 되었습니다.")
                .build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
