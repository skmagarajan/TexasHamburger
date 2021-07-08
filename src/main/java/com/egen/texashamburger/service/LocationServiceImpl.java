package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.LocationDTO;
import com.egen.texashamburger.entity.Location;
import com.egen.texashamburger.exception.LocationServiceException;
import com.egen.texashamburger.repository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Boolean createLocation(LocationDTO locationDTO) {
        try{
            Location LocationEntity = new Location();
            BeanUtils.copyProperties(locationDTO, LocationEntity);
            locationRepository.insert(LocationEntity);
        }
        catch (Exception e){
            throw new LocationServiceException("Internal Server Error",e);
        }
        return true;
    }

    @Override
    public List<Location> getAllLocations() {
        try{
            return locationRepository.findAll();
        }
        catch (Exception e){
            throw new LocationServiceException("Internal Server Error",e);
        }
    }
}
