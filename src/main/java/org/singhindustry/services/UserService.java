package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Role;
import org.singhindustry.entities.User;
import org.singhindustry.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	 @Autowired
	    private UserRepository userRepository;

	    public void createAdmin(User user) {
	        BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
	        user.setPassword(encoder.encode(user.getPassword()));
	        Role userRole = new Role("ADMIN");
	        List<Role> roles = new ArrayList<>();
	        roles.add(userRole);
	        user.setRoles(roles);
	        userRepository.save(user);
	    }

	    public User findOne(String email) {
	        return userRepository.findById(email).orElse(null);
	    }

	    public boolean isUserPresent(String email) {
	        User u=userRepository.findById(email).orElse(null);
	        if(u!=null)
	            return true;
	        return false;
	    }

	    public List<User> findAll() {
	        return userRepository.findAll();
	    }

	    public List<User> findByName(String name) {
	        return  userRepository.findByNameLike("%"+name+"%");
	    }

}
