package com.cojar.whats_hot.domain.review.entity;

import lombok.Getter;

@Getter
public enum ReviewStatus {

    DRAFT("draft"),
    PUBLIC("public"),
    PRIVATE("private");

    private String status;

    ReviewStatus(String status) {
        this.status = status;
    }
}
