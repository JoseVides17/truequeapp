package com.videstech.truequeapp.mapper;

import com.videstech.truequeapp.dto.review.ReviewCreateDTO;
import com.videstech.truequeapp.dto.review.ReviewDTO;
import com.videstech.truequeapp.model.Review;
import com.videstech.truequeapp.model.User;

import java.time.LocalDateTime;

public class ReviewMapper {

    public static ReviewDTO toDTO(Review review) {
        if (review == null) return null;

        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setReviewerId(review.getReviewer().getId());
        dto.setReviewedId(review.getReviewed().getId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setCreatedAt(review.getCreatedAt());
        return dto;
    }

    public static Review toEntity(ReviewCreateDTO dto, User reviewer, User reviewed) {
        if (dto == null) return null;

        Review review = new Review();
        review.setReviewer(reviewer);
        review.setReviewed(reviewed);
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setCreatedAt(LocalDateTime.now());
        return review;
    }
}

