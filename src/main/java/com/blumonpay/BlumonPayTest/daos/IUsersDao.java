package com.blumonpay.BlumonPayTest.daos;

import java.util.Optional;

import com.blumonpay.BlumonPayTest.entities.User;

public interface IUsersDao extends IGenericDao<User, Long> {
	Optional<User> findByUsername(String username);
}
