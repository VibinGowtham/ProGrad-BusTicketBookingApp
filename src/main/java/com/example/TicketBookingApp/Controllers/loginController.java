package com.example.TicketBookingApp.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.TicketBookingApp.Model.User;
import com.example.TicketBookingApp.Services.MyUserDetailsService;
import com.example.TicketBookingApp.UserRepository.UserRepository;
import com.example.TicketBookingApp.Util.Util;


@Controller
public class loginController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	 private Util util;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@PostMapping("/authenticate")
	@ResponseBody
	public ResponseEntity<?> authenticate(String userName,String password) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
		}
		catch(AuthenticationException e) {throw new Exception("Incorrect Username and Passowrd",e);}

			UserDetails userdetails= myUserDetailsService.loadUserByUsername(userName);
			String jwt=util.generateToken(userdetails);
			System.out.print(jwt);
			return ResponseEntity.ok(jwt);
		
		
	}
	
	@GetMapping(path="/home")
	@ResponseBody
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
