package com.library.controller;

import com.library.dto.BookDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("book")
public class BookController {
    List<BookDto> books = new ArrayList<>();

    @GetMapping("/list")
    public List<BookDto> getBookList(){
        return books;
    }

    @PostMapping("create")
    public BookDto createBook(@RequestBody BookDto dto){
        if(dto.getAuthor().isEmpty() || dto.getTitle().isEmpty()) return null;
        dto.setId(UUID.randomUUID().toString());
        dto.setPublishedYear(LocalDateTime.now());

        books.add(dto);
        return dto;
    }

    @GetMapping("/by-id/{id}")
    public BookDto getBookById(@PathVariable String id){
        for(BookDto bookDto :books){
            if (bookDto.getId().equals(id)) return bookDto;
        }
        return null;
    }

}
