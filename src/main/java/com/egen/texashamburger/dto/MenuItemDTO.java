package com.egen.texashamburger.dto;

import com.egen.texashamburger.enums.MenuCategory;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class MenuItemDTO implements Serializable {
    private String name;
    private BigDecimal price;
    private MenuCategory category;
}
