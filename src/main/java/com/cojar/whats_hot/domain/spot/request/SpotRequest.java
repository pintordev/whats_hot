package com.cojar.whats_hot.domain.spot.request;

import com.cojar.whats_hot.domain.category.dto.CategoryDto;
import com.cojar.whats_hot.domain.hashtag.dto.HashtagDto;
import com.cojar.whats_hot.domain.menu_item.dto.MenuItemDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class SpotRequest {

    @Getter
    public static class Create {

        @Valid
        private CategoryDto category;

        @NotBlank
        private String address;

        @NotBlank
        private String contact;

        @Valid
        @NotNull
        private List<HashtagDto> hashtags;

        @Valid
        private List<MenuItemDto> menuItems;
    }
}
