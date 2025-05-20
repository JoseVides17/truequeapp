package com.videstech.truequeapp.dto.review;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private Long id;
    private Long reviewerId;
    private Long reviewedId;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
}

