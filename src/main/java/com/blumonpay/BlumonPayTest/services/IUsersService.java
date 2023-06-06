package com.blumonpay.BlumonPayTest.services;

import java.util.Optional;

import com.blumonpay.BlumonPayTest.entities.User;

public interface IUsersService extends IGenericService<User, Long> {

	User findByUsername(String username);
	
}
