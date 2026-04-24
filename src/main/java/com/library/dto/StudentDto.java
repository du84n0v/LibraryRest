package com.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class StudentDto {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private LocalDateTime createdDate;
}
