package com.cojar.whats_hot.domain.review.entity;

import lombok.Getter;

@Getter
public enum ReviewStatus {

    DRAFT("draft"),
    PUBLIC("public"),
    PRIVATE("private");

    private String type;

    ReviewStatus(String type) {
        this.type = type;
    }
}
