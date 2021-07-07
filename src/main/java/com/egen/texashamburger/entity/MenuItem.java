package com.egen.texashamburger.entity;

import com.egen.texashamburger.enums.MenuCategory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Document(collection="menuItem")
public class MenuItem extends Auditing{
    @Id
    private String menuItemId;
    @Indexed(unique=true)
    private String name;
    private BigDecimal price;
    private MenuCategory category;
}
