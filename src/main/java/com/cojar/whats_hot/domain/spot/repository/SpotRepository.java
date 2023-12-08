package com.cojar.whats_hot.domain.spot.repository;

import com.cojar.whats_hot.domain.spot.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
