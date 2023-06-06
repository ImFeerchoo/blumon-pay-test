package com.blumonpay.BlumonPayTest.validators;

import org.springframework.stereotype.Component;

import com.blumonpay.BlumonPayTest.entities.User;
import com.blumonpay.BlumonPayTest.exceptions.ErrorWritingInformationException;

@Component
public class UserValidator {

	public void isUserValidToSave(User user) {
		if(
				user.getName() == null ||
				user.getName().isBlank() ||
				user.getLastName() == null ||
				user.getLastName().isBlank() ||
				user.getUsername() == null ||
				user.getUsername().isBlank() ||
				user.getPassword() == null ||
				user.getPassword().isBlank()
			)
			throw new ErrorWritingInformationException("User not valid to save");
	}
	
	public void isTerminalValidToUpdate(User user) {
		if(
				user.getIdUser() == null ||
				user.getIdUser() <= 0 ||
				user.getName() == null ||
				user.getName().isBlank() ||
				user.getLastName() == null ||
				user.getLastName().isBlank() ||
				user.getUsername() == null ||
				user.getUsername().isBlank() ||
				user.getPassword() == null ||
				user.getPassword().isBlank()
				)
			throw new ErrorWritingInformationException("User not valid to update");
	}
	
}
