package com.cojar.whats_hot.domain.hashtag.dto;

import com.cojar.whats_hot.domain.hashtag.entity.Hashtag;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class HashtagDto {

    @NotBlank
    private final String name;

    @JsonCreator
    public HashtagDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    public HashtagDto (Hashtag hashtag) {
        this.name = hashtag.getName();
    }

    public static HashtagDto of(Hashtag hashtag) {
        return new HashtagDto(hashtag);
    }
}
