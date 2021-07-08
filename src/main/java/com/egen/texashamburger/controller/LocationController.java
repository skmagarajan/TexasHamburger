package com.egen.texashamburger.controller;

import com.egen.texashamburger.dto.LocationDTO;
import com.egen.texashamburger.entity.Location;
import com.egen.texashamburger.response.Response;
import com.egen.texashamburger.response.ResponseMetadata;
import com.egen.texashamburger.response.StatusMessage;
import com.egen.texashamburger.service.LocationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/location")
@NoArgsConstructor
public class LocationController {

    @Autowired
    private LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @PostMapping("/create")
    public Response<String> createLocation(@RequestBody LocationDTO location){
        return locationService.createLocation(location) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Location Created")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Location Not Created")
                        .build();
    }

    @GetMapping(value="/getAll",produces = "application/json")
    public Response<List<Location>> getAllLocations(){
        return Response.<List<Location>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((locationService.getAllLocations()))
                .build();
    }
}
