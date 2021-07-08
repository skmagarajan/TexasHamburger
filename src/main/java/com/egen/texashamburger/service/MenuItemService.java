package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.MenuItemDTO;
import com.egen.texashamburger.entity.MenuItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public interface MenuItemService {
    Boolean createMenuItem(MenuItemDTO menu);
    List<MenuItem> getAllMenuItems();
    List<MenuItem> getAllMenuItemsByCategory(String category);
    MenuItem updatePriceByMenuName(String menuName, BigDecimal price);
    String removeMenuItemByName(String menuItemName);
    Map<String, Object> getAllByPageSize(int page, int size);
}
