package com.cojar.whats_hot.domain.category.repository;

import com.cojar.whats_hot.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
