package com.videstech.truequeapp.service.review;

import com.videstech.truequeapp.dto.review.ReviewCreateDTO;
import com.videstech.truequeapp.dto.review.ReviewDTO;
import com.videstech.truequeapp.mapper.ReviewMapper;
import com.videstech.truequeapp.model.Review;
import com.videstech.truequeapp.model.User;
import com.videstech.truequeapp.repository.ReviewRepository;
import com.videstech.truequeapp.repository.UserRepository;
import com.videstech.truequeapp.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final UserServiceImpl userServiceImpl;

    @Override
    public ReviewDTO create(ReviewCreateDTO dto) {
        User reviewer = userServiceImpl.getAuthenticatedUser();
        User reviewed = userRepository.findById(dto.getReviewedId()).orElseThrow(() -> new RuntimeException("Reviewed not found"));
        if (reviewer.getId().equals(reviewed.getId())) {
            throw new RuntimeException("No puedes calificarte tu mismo");
        }
        Review review = ReviewMapper.toEntity(dto, reviewer, reviewed);
        Review saved = reviewRepository.save(review);
        return ReviewMapper.toDTO(saved);
    }

    @Override
    public List<ReviewDTO> getReviewsForUser(Long userId) {
        User authUser = userServiceImpl.getAuthenticatedUser();
        if (!authUser.getId().equals(userId)){
            throw new RuntimeException("Solo puedes ver calificaciones hechas por ti mismo.");
        }
        return reviewRepository.findByReviewedId(userId)
                .stream()
                .map(ReviewMapper::toDTO)
                .collect(Collectors.toList());
    }
}

