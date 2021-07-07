package com.egen.texashamburger.dto;

import com.egen.texashamburger.entity.Location;
import com.egen.texashamburger.enums.OrderType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CustomerOrderDTO implements Serializable {

    private String restaurantId;
    private String username;
    private List<String> itemsOrdered;
    private BigDecimal taxAmount;
    private OrderType orderType;
    private Location location;
}
