package com.cojar.whats_hot.domain.service.repository;

import com.cojar.whats_hot.domain.service.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
