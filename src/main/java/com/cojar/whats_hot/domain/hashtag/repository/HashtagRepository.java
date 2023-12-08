package com.cojar.whats_hot.domain.hashtag.repository;

import com.cojar.whats_hot.domain.hashtag.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}
