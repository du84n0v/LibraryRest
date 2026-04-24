package com.library.dto;

import com.library.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class StudentBookDto {
    private String id;
    private String studentId;
    private String bookId;
    private LocalDateTime createdDate;
    private Status status;
    private LocalDateTime returnedDate;
}
