package com.cojar.whats_hot.domain.comment.repository;

import com.cojar.whats_hot.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
