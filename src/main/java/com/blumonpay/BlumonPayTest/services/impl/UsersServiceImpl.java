package com.blumonpay.BlumonPayTest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blumonpay.BlumonPayTest.daos.IGenericDao;
import com.blumonpay.BlumonPayTest.daos.IUsersDao;
import com.blumonpay.BlumonPayTest.entities.User;
import com.blumonpay.BlumonPayTest.exceptions.NoInformationFoundException;
import com.blumonpay.BlumonPayTest.services.IGenericCrud;
import com.blumonpay.BlumonPayTest.services.IUsersService;
import com.blumonpay.BlumonPayTest.validators.UserValidator;

@Service
public class UsersServiceImpl extends IGenericCrud<User, Long> implements IUsersService {
	
	@Autowired
	private IUsersDao repo;
	
	@Autowired
	private UserValidator userValidator;

	@Override
	protected IGenericDao<User, Long> getRepo() {
		return repo;
	}

	@Override
	protected void validateEntityToSave(User t) {
		userValidator.isUserValidToSave(t);
	}

	@Override
	protected void validateEntityToUpdate(User t) {
		userValidator.isTerminalValidToUpdate(t);
	}

	@Override
	public User findByUsername(String username) {
		return repo.findByUsername(username).orElseThrow(() -> {
			return new NoInformationFoundException("User not found");
		});
	}

}
