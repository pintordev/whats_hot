package com.cojar.whats_hot.domain.menu_item.service;

import com.cojar.whats_hot.domain.menu_item.entity.MenuItem;
import com.cojar.whats_hot.domain.menu_item.repository.MenuItemRepository;
import com.cojar.whats_hot.domain.spot.entity.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItem create(String name, String price, Spot spot) {

        MenuItem menuItem = MenuItem.builder()
                .name(name)
                .price(price)
                .spot(spot)
                .build();

        this.menuItemRepository.save(menuItem);

        return menuItem;
    }
}
