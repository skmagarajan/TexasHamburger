package com.egen.texashamburger.entity;

import com.egen.texashamburger.enums.OrderType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection="CustomerOrder")
public class CustomerOrder extends Auditing{
    @Id
    private String id;

    private String username;
    private String restaurantId;
    private List<String> itemsOrdered;
    private BigDecimal priceAmount;
    private BigDecimal taxAmount;
    private BigDecimal totalAmount;
    private OrderType orderType;
    private Location location;
}
