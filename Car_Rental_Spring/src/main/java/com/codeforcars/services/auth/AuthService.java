package com.codeforcars.services.auth;

import com.codeforcars.dto.SignupRequest;
import com.codeforcars.dto.UserDto;

public interface AuthService {

	UserDto createCustomer(SignupRequest signupRequest);

	boolean hasCustomerWithEmail(String email);
}
