package com.egen.texashamburger.controller;

import com.egen.texashamburger.dto.MenuItemDTO;
import com.egen.texashamburger.entity.MenuItem;
import com.egen.texashamburger.enums.MenuCategory;
import com.egen.texashamburger.exception.MenuServiceException;
import com.egen.texashamburger.response.Response;
import com.egen.texashamburger.response.ResponseMetadata;
import com.egen.texashamburger.response.StatusMessage;
import com.egen.texashamburger.service.MenuItemService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/menuItem")
@NoArgsConstructor
public class MenuItemController {


    private MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService){
        this.menuItemService = menuItemService;
    }

    @PostMapping("/create")
    public Response<String> createMenuItem(@RequestBody MenuItemDTO menu){
        return menuItemService.createMenuItem(menu) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Menu Created")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Menu Not Created")
                        .build();
    }


    @GetMapping(value="/getAll",produces = "application/json")
    public Response<List<MenuItem>> getAllMenus(){
        return Response.<List<MenuItem>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuItemService.getAllMenuItems()))
                .build();
    }

    @GetMapping(value="/category/{category}",produces = "application/json")
    public Response<List<MenuItem>> getAllMenusByCategory(@PathVariable String category){
        if(!Arrays.stream(MenuCategory.values()).anyMatch((t) -> t.name().equals(category))){
            throw new MenuServiceException("Check Request Parameter");
        }
        return Response.<List<MenuItem>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuItemService.getAllMenuItemsByCategory(category)))
                .build();
    }

    @PutMapping(value="/update/{menuItemName}/{price}",produces = "application/json")
    public Response<MenuItem> updatePriceByMenuName(@PathVariable String menuItemName, @PathVariable BigDecimal price){
        return Response.<MenuItem>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuItemService.updatePriceByMenuName(menuItemName,price)))
                .build();
    }

    @DeleteMapping(value="/remove/{menuItemName}/",produces = "application/json")
    public Response<String> removeMenuItemByName(@PathVariable String menuItemName){
        return Response.<String>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuItemService.removeMenuItemByName(menuItemName)))
                .build();
    }

    @GetMapping(value="/getAll/{page}/{size}",produces = "application/json")
    public Response<Map<String, Object>> getAllByPageSize(@PathVariable int page, @PathVariable int size){
        return Response.<Map<String, Object>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuItemService.getAllByPageSize(page,size)))
                .build();
    }
}
