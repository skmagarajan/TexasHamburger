package com.egen.texashamburger.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@Document(collection="location")
public class Location extends Auditing{
    @Id
    private String locationId;

    private String address;
    private String state;
    private String city;
    private Integer zipcode;
}
