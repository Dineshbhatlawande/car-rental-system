package com.codeforcars.services.auth;

import com.codeforcars.enums.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeforcars.dto.SignupRequest;
import com.codeforcars.dto.UserDto;
import com.codeforcars.entity.User;
import com.codeforcars.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
   private final UserRepository userRepository;
   
   @Override
   public UserDto createCustomer(SignupRequest signupRequest) {
	   User user=new User();
	   user.setName(signupRequest.getName());
	   user.setEmail(signupRequest.getEmail());
	   user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
	   user.setUserRole (UserRole.CUSTOMER);
	   User createdUser = userRepository.save(user);
	   UserDto userDto = new UserDto();
	   userDto.setId(createdUser.getId());
	   return userDto;
   }

	@Override
//	public boolean hasCustomerWithEmail(String email) {
//		return userRepository.findFirstByEmail(email);
//	}
	public boolean hasCustomerWithEmail(String email) {
		Optional<User> userOptional = userRepository.findFirstByEmail(email);
		return userOptional.isPresent(); // Returns true if user with the given email exists, false otherwise
	}
}
