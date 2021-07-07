package com.egen.texashamburger.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection="restaurant")
public class Restaurant extends Auditing {
    @Id
    private String restaurantId;

    private String restaurantCode;
    private List<String> menuItems;
    private Location location;
    private Boolean driveThrough;
    private Integer numberOfTablesAvailable;
}