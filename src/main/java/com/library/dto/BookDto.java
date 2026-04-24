package com.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class BookDto {
    private String id;
    private String title;
    private String author;
    private LocalDateTime publishedYear;
}
