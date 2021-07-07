package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.RestaurantDTO;
import com.egen.texashamburger.entity.Restaurant;
import com.egen.texashamburger.exception.RestaurantServiceException;
import com.egen.texashamburger.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Boolean createRestaurant(RestaurantDTO restaurantDTO) {
        try{
            Restaurant RestaurantEntity = new Restaurant();
            BeanUtils.copyProperties(restaurantDTO, RestaurantEntity);
            restaurantRepository.insert(RestaurantEntity);
        }
        catch (Exception e){
            throw new RestaurantServiceException("Internal Server Error",e);
        }
        return true;
    }

}
