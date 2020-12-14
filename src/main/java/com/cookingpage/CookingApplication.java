package com.cookingpage;

import com.cookingpage.domain.User;
import com.cookingpage.domain.security.MyUserDetails;
import com.cookingpage.domain.security.Role;
import com.cookingpage.service.UserService;
import com.cookingpage.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CookingApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//User user1 = new User("Dawid", "badura", "admin", SecurityUtility.passwordEncoder().encode("dwd"), "dawid.badurakrk@gmail.com");

		User user1 = new User();
		User user2 = new User();

		user1.setFirstName("Dawid");
		user1.setLastName("Badura");
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("dawid.badurakrk@gmail.com");

		user2.setFirstName("Dawid");
		user2.setLastName("Badura");
		user2.setUsername("user");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("user"));
		user2.setEmail("dawid.badurakrk@gmail.com");

		Role role1= new Role();
		Role role2= new Role();

		role1.setName("ROLE_ADMIN");
		role2.setName("ROLE_USER");

		user1.addRole(role1);
		user2.addRole(role2);
		MyUserDetails userDetails = new MyUserDetails(user1);
		MyUserDetails userDetails2 = new MyUserDetails(user2);

		userService.createUser(user1/*, userRoles*/);
		userService.createUser(user2/*, userRoles*/);
	}
}
