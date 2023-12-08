package com.cojar.whats_hot.domain.hashtag.entity;

import com.cojar.whats_hot.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
public class Hashtag extends BaseEntity {

    private String name;
}
