package com.cojar.whats_hot.domain.spot.entity;

import com.cojar.whats_hot.domain.category.entity.Category;
import com.cojar.whats_hot.domain.file.entity.SaveFile;
import com.cojar.whats_hot.domain.hashtag.entity.Hashtag;
import com.cojar.whats_hot.domain.menu_item.entity.MenuItem;
import com.cojar.whats_hot.domain.review.entity.Review;
import com.cojar.whats_hot.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
public class Spot extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    private String address;

    private String contact;

    @Builder.Default
    private Double averageScore = 0.0;

    @ManyToMany
    private List<Hashtag> hashtags;

    @OneToMany(mappedBy = "spot", cascade = CascadeType.REMOVE)
    private List<MenuItem> menuItems;

    @OneToMany(mappedBy = "spot", cascade = CascadeType.REMOVE)
    private List<SaveFile> images;

    @OneToMany(mappedBy = "spot", cascade = CascadeType.REMOVE)
    private List<Review> reviews;
}
