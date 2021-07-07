package com.egen.texashamburger.service;

import com.egen.texashamburger.entity.User;
import com.egen.texashamburger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if(user != null){
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        }
        else{
            throw new UsernameNotFoundException("User not found: "+username);
        }
        return userDetails;
    }
}
