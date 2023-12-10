package com.cojar.whats_hot.domain.file.entity;

import com.cojar.whats_hot.domain.review.entity.Review;
import com.cojar.whats_hot.domain.spot.entity.Spot;
import com.cojar.whats_hot.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
public class SaveFile extends BaseEntity {

    private String primaryPath;

    private String secondaryPath;

    private String uploader;

    private String date;

    private String ext;

    @ManyToOne(fetch = FetchType.LAZY)
    private Spot spot;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    public String toUri() {
        return "image uri";
    }
}
