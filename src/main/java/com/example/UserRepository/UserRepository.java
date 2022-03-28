package com.example.UserRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.Model.User;



//import com.example.TicketBookingApp.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

}