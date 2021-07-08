package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.UserDTO;
import com.egen.texashamburger.entity.User;
import com.egen.texashamburger.exception.RestaurantServiceException;
import com.egen.texashamburger.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Boolean addUser(UserDTO user) {
        try{
            String pwd = user.getPassword();
            String encryption = passwordEncoder.encode(pwd);
            User userEntity = new User();
            BeanUtils.copyProperties(user,userEntity);
            userEntity.setPassword(encryption);
            userRepository.save(userEntity);
        }
        catch (Exception e){
            throw new RestaurantServiceException("Internal Server Error",e);
        }
        return true;
    }
}
