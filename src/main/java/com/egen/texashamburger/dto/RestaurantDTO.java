package com.egen.texashamburger.dto;

import com.egen.texashamburger.entity.Location;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RestaurantDTO implements Serializable {
    private String restaurantCode;

    private List<String> menuItems;
    private Location location;
    private Boolean driveThrough;
    private Integer numberOfTablesAvailable;
}
