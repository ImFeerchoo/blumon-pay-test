package com.blumonpay.BlumonPayTest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blumonpay.BlumonPayTest.daos.IGenericDao;
import com.blumonpay.BlumonPayTest.daos.ITerminalsDao;
import com.blumonpay.BlumonPayTest.entities.Terminal;
import com.blumonpay.BlumonPayTest.services.IGenericCrud;
import com.blumonpay.BlumonPayTest.services.ITerminalsService;
import com.blumonpay.BlumonPayTest.validators.TerminalValidator;

@Service
public class TerminalsServiceImpl extends IGenericCrud<Terminal, Long> implements ITerminalsService {
	
	@Autowired
	private ITerminalsDao terminalsDao;
	
	@Autowired
	private TerminalValidator validator;

	@Override
	protected IGenericDao<Terminal, Long> getRepo() {
		return terminalsDao;
	}

	@Override
	protected void validateEntityToSave(Terminal terminal) {
		validator.isTerminalValidToSave(terminal);
	}

	@Override
	protected void validateEntityToUpdate(Terminal terminal) {
		validator.isTerminalValidToUpdate(terminal);
	}

}
