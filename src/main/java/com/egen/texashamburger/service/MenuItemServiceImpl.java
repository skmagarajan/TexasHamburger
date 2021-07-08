package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.MenuItemDTO;
import com.egen.texashamburger.entity.MenuItem;
import com.egen.texashamburger.exception.MenuServiceException;
import com.egen.texashamburger.repository.MenuItemRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public Boolean createMenuItem(MenuItemDTO menuItemDTO) {
        try{
            MenuItem menuItemEntity = new MenuItem();
            BeanUtils.copyProperties(menuItemDTO, menuItemEntity);
            menuItemRepository.insert(menuItemEntity);
        }
        catch (Exception e){
            throw new MenuServiceException("Internal Server Error",e);
        }
        return true;
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        try {
            List<MenuItem> menuItems = menuItemRepository.findAll();
            return menuItems;
        } catch (Exception e) {
            throw new MenuServiceException("MenuItem Not Found",e);
        }
    }

    @Override
    public List<MenuItem> getAllMenuItemsByCategory(String category) {
        try {
            List<MenuItem> menuItems = menuItemRepository.findAllByCategory(category);
            return menuItems;
        } catch (Exception e) {
            throw new MenuServiceException("MenuItem Not Found",e);
        }
    }

    @Override
    public MenuItem updatePriceByMenuName(String menuName, BigDecimal price) {
        try {
            List<MenuItem> menuItem = menuItemRepository.findAllByName(menuName);
            if(menuItem.size() == 1)
                menuItem.get(0).setPrice(price);
            menuItemRepository.save(menuItem.get(0));
            return menuItem.get(0);
        } catch (Exception e) {
            throw new MenuServiceException("MenuItem Not Found", e);
        }
    }

    @Override
    public String removeMenuItemByName(String menuItemName) {
        try {
            List<MenuItem> menuItem = menuItemRepository.findAllByName(menuItemName);
            if(menuItem.size() == 1)
                menuItemRepository.removeMenuItemsByName(menuItemName);
            return "Removed Successfully";
        } catch (Exception e) {
            throw new MenuServiceException("MenuItem Not Found", e);
        }
    }

    @Override
    public Map<String, Object> getAllByPageSize(int page, int size) {
        try {
            List<MenuItem> menuItems = new ArrayList<MenuItem>();
            Pageable paging = PageRequest.of(page-1,size);

            Page<MenuItem> pageMenuItem = menuItemRepository.findAll(paging);
            menuItems = pageMenuItem.getContent();
            Map<String, Object> response = new HashMap<>();

                response.put("Items", menuItems);
                response.put("currentPage", pageMenuItem.getNumber()+1);
                response.put("totalItems", pageMenuItem.getTotalElements());
                response.put("totalPages", pageMenuItem.getTotalPages());

            return response;
        } catch (Exception e) {
            throw new MenuServiceException("MenuItem Not Found", e);
        }
    }
}
