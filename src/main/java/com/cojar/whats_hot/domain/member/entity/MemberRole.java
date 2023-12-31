package com.cojar.whats_hot.domain.member.entity;

import lombok.Getter;

@Getter
public enum MemberRole {

    ADMIN("admin"),
    USER("user");

    private String type;

    MemberRole(String type) {
        this.type = type;
    }
}
