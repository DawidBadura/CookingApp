package com.cookingpage.service.impl;

import com.cookingpage.domain.User;
import com.cookingpage.domain.security.PasswordResetToken;
import com.cookingpage.repository.PasswordResetTokenRepository;
import com.cookingpage.repository.RoleRepository;
import com.cookingpage.repository.UserRepository;
import com.cookingpage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}
	
	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	
	@Override
	public User findByEmail (String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User createUser(User user/*, Set<UserRole> userRoles*/){
		User localUser = userRepository.getUserByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {
			/*for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}*/
			
		//	user.getUserRoles().addAll(userRoles);
			
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
