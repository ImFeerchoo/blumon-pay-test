package com.blumonpay.BlumonPayTest.validators;

import org.springframework.stereotype.Component;

import com.blumonpay.BlumonPayTest.entities.Terminal;
import com.blumonpay.BlumonPayTest.exceptions.ErrorWritingInformationException;

@Component
public class TerminalValidator {
	
	public void isTerminalValidToSave(Terminal terminal) {
		if(
				terminal.getName() == null ||
				terminal.getName().isBlank() ||
				terminal.getLastName() == null ||
				terminal.getLastName().isBlank() ||
				terminal.getBornDate() == null ||
				terminal.getCardNumber() == null ||
				terminal.getCardNumber().isBlank() ||
				terminal.getBank() == null ||
				terminal.getBank().isBlank()
			)
			throw new ErrorWritingInformationException("Terminal not valid to save");
	}
	
	public void isTerminalValidToUpdate(Terminal terminal) {
		if(
				terminal.getIdTerminal() == null ||
				terminal.getIdTerminal() <= 0 ||
				terminal.getName() == null ||
				terminal.getName().isBlank() ||
				terminal.getLastName() == null ||
				terminal.getLastName().isBlank() ||
				terminal.getBornDate() == null ||
				terminal.getCardNumber() == null ||
				terminal.getCardNumber().isBlank() ||
				terminal.getBank() == null ||
				terminal.getBank().isBlank()
				)
			throw new ErrorWritingInformationException("Terminal not valid to update");
	}
	
}
