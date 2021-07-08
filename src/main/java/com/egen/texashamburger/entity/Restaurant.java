package com.egen.texashamburger.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection="restaurant")
public class Restaurant extends Auditing {
    @Id
    private String restaurantId;

    @Indexed(unique = true)
    private String restaurantCode;

    private List<String> menuItems;
    private Location location;
    private Boolean driveThrough;
    private Integer numberOfTablesAvailable;
}