package org.singhindustry;

import org.singhindustry.entities.User;
import org.singhindustry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SinghIndustryApplication implements CommandLineRunner{
	
	  @Autowired
	   private UserService userService;
	  
	public static void main(String[] args) {
		SpringApplication.run(SinghIndustryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		{
            User newAdmin = new User("admin@gmail.com","admin","123456");
            userService.createAdmin(newAdmin);
        }
				
	}
	
	
}

