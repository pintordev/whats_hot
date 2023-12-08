package com.cojar.whats_hot.domain.review.repository;

import com.cojar.whats_hot.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
