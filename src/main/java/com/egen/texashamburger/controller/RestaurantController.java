package com.egen.texashamburger.controller;

import com.egen.texashamburger.dto.RestaurantDTO;
import com.egen.texashamburger.response.Response;
import com.egen.texashamburger.response.ResponseMetadata;
import com.egen.texashamburger.response.StatusMessage;
import com.egen.texashamburger.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {


    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping("/create")
    public Response<String> createRestaurant(@RequestBody RestaurantDTO restaurant){
        return restaurantService.createRestaurant(restaurant) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Restaurant Created")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Menu Not Created")
                        .build();
    }

}
