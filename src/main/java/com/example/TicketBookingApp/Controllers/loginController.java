package com.example.TicketBookingApp.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketBookingApp.Model.User;
import com.example.TicketBookingApp.UserRepository.UserRepository;


@Controller
public class loginController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/home")
	public String displayHomepage() {
		return "Homepage.jsp";
	}
	
	@GetMapping(path="/register")
	public String displayRegisterpage() {
		return "Register.jsp";
	}
	
	 @GetMapping(path="/login") 
	    public String login() {
	    	return "Login.jsp";
	    }
	 
    @PostMapping(path="/register") 
    public String registerUser(User user) {
    	if(userRepository.findAll().isEmpty()) 
 		    {
    		userRepository.save(user);
    		System.out.print("1");
    		return "Login.jsp";
		      }
    	else {
    		if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
    			userRepository.save(user);
    			System.out.print("2");
    			return "Login.jsp";
    		}
    		else return "AlreadyRegistered.jsp";
    	}
   }
    
    @PostMapping(path="/login") 
    public String loginUser(User user) {
      	if(userRepository.findAll().isEmpty()) 
 		    {
    		return "NoUser.jsp";
		      }
    	else {
    		if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
    			return "InvalidUser.jsp";
    		}
    		else{
    			List<User> tempUser=userRepository.findByEmail(user.getEmail());
    			for(User object:tempUser) {
    				if(object.getEmail().equals(user.getEmail()) && object.getPassword().equals(user.getPassword())) return "Homepage.jsp";
    			}
    		}
    	}
       return "InvalidUser.jsp";
   }
    
    @GetMapping(path="/all") 
    public @ResponseBody Iterable<User> gettAll() {
        return userRepository.findAll();
    }
}
