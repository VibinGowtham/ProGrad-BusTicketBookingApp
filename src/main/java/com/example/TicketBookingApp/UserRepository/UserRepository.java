package com.example.TicketBookingApp.UserRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.TicketBookingApp.Model.MyUser;



//import com.example.TicketBookingApp.User;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

	List<MyUser> findByEmail(String email);
	List<MyUser> findByName(String name);

}