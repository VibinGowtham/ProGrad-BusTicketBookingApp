package com.example.TicketBookingApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TicketBookingApp.Model.MyUser;
import com.example.TicketBookingApp.UserRepository.UserRepository;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
 @Autowired
 UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    	MyUser user=userRepository.findByName(name);
        return new User(user.getName(),user.getPassword(),new ArrayList<>());
    }
}