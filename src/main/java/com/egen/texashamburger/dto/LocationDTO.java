package com.egen.texashamburger.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LocationDTO implements Serializable {
    private String address;
    private String state;
    private String city;
    private Integer zipcode;
}
