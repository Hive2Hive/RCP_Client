package org.hive2hive.rcp.client.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutUserHandler {
	private static final Logger logger = LoggerFactory.getLogger(LogoutUserHandler.class);

	@Execute
	public void logoutUser() {
		logger.debug("Logout user...");
	}

}
