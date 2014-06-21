package org.hive2hive.rcp.client.services;

import java.nio.file.Path;

import org.eclipse.e4.core.services.events.IEventBroker;

public interface IUserService {

	public final String USER_STATUS = "USER_STATUS";

	enum Status {
		REGISTERING_USER,
		REGISTER_SUCCESSFULL,
		RESISTER_FAILED,
		LOGGING_IN_USER,
		LOGIN_SUCCESSFUL,
		LOGIN_FAILED,
		LOGGING_OUT_USER,
		LOGOUT_SUCCESSFULL,
		LOGOUT_FAILED
	}

	void initUserService(IEventBroker eventBroker);

	boolean isUserRegistered(String userId);

	void test();

	void registerAndLoginUser(String userId, String password, String pin, Path rootDirPath);

}
