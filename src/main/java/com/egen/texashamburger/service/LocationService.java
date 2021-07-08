package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.LocationDTO;
import com.egen.texashamburger.entity.Location;

import java.util.List;

public interface LocationService {
    Boolean createLocation(LocationDTO location);
    List<Location> getAllLocations();
}
