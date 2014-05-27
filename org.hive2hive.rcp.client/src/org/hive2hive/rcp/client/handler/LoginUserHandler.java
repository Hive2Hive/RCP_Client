package org.hive2hive.rcp.client.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginUserHandler {
	private static final Logger logger = LoggerFactory.getLogger(LoginUserHandler.class);

	@Execute
	public void loginUser() {
		logger.debug("Login user...");
	}
}
