package com.example.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.User;
import com.example.UserRepository.UserRepository;
@RestController
public class loginController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/home")
	public String displayHomepage() {
		return "Homepage";
	}
	
    @PostMapping(path="/register") 
    public String registerUser(@RequestBody User user) {
    	if(userRepository.findAll().isEmpty()) 
 		    {
    		userRepository.save(user);
    		return "You are the first User";
		      }
    	else {
    		if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
    			userRepository.save(user);
    		}
    		else return "You already Registered with this credentials.";
    	}
       return "Register Not Successfull";
   }
    
    @PostMapping(path="/login") 
    public String loginUser(@RequestBody User user) {
    	System.out.println(userRepository.findByEmail(user.getEmail()).isEmpty());
    	System.out.println(userRepository.findAll().isEmpty());
    	
    	if(userRepository.findAll().isEmpty()) 
 		    {
    		return "No users found";
		      }
    	else {
    		if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
    			return "Enter valid details";
    		}
    		else{
    			List<User> tempUser=userRepository.findByEmail(user.getEmail());
    			for(User object:tempUser) {
    				System.out.print(object.getEmail().equals(user.getEmail()));
    				System.out.print(object.getPassword().equals(user.getPassword()));
    				if(object.getEmail().equals(user.getEmail()) && object.getPassword().equals(user.getPassword())) return "Logged in";
    			}
    		}
    	}
       return "Login Not Successfull";
   }
    
    @GetMapping(path="/all") 
    public @ResponseBody Iterable<User> gettAll() {
        return userRepository.findAll();
    }
}
