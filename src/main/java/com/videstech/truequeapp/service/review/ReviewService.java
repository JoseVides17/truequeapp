package com.videstech.truequeapp.service.review;

import com.videstech.truequeapp.dto.review.ReviewCreateDTO;
import com.videstech.truequeapp.dto.review.ReviewDTO;
import com.videstech.truequeapp.model.Review;

import java.util.List;

public interface ReviewService {
    ReviewDTO create(ReviewCreateDTO dto);
    List<ReviewDTO> getReviewsForUser(Long userId);
}

