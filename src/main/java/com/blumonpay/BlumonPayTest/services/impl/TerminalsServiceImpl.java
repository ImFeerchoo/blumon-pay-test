package com.blumonpay.BlumonPayTest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blumonpay.BlumonPayTest.daos.IGenericDao;
import com.blumonpay.BlumonPayTest.daos.ITerminalsDao;
import com.blumonpay.BlumonPayTest.entities.Terminal;
import com.blumonpay.BlumonPayTest.services.IGenericCrud;
import com.blumonpay.BlumonPayTest.services.ITerminalsService;

@Service
public class TerminalsServiceImpl extends IGenericCrud<Terminal, Long> implements ITerminalsService {
	
	@Autowired
	private ITerminalsDao terminalsDao;

	@Override
	protected IGenericDao<Terminal, Long> getRepo() {
		return terminalsDao;
	}

}
