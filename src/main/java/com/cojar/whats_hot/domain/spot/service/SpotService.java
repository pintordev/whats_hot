package com.cojar.whats_hot.domain.spot.service;

import com.cojar.whats_hot.domain.category.entity.Category;
import com.cojar.whats_hot.domain.hashtag.entity.Hashtag;
import com.cojar.whats_hot.domain.spot.entity.Spot;
import com.cojar.whats_hot.domain.spot.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SpotService {

    private final SpotRepository spotRepository;

    public boolean hasNoSpot() {
        return this.spotRepository.count() == 0;
    }

    public Spot create(Category category, String address, String contact, List<Hashtag> hashtags) {

        Spot spot = Spot.builder()
                .category(category)
                .address(address)
                .contact(contact)
                .hashtags(hashtags).build();

        this.spotRepository.save(spot);

        return spot;
    }

    public Spot getSpotById(Long id) {
        return this.spotRepository.findById(id)
                .orElse(null);
    }
}
