package com.egen.texashamburger.repository;

import com.egen.texashamburger.entity.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuItemRepository extends MongoRepository<MenuItem,String> {
    List<MenuItem> findAllByCategory(String category);
    List<MenuItem> findAllByName(String menuItemName);
    String removeMenuItemsByName(String menuItemName);
}
