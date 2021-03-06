package com.cookingpage.service;

import com.cookingpage.domain.User;
import com.cookingpage.domain.security.PasswordResetToken;

import java.util.Optional;
import java.util.Set;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);

	Optional<User> findById(Long id);

	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User createUser(User user/*, Set<UserRole> userRoles*/) throws Exception;
	
	User save(User user);
}
