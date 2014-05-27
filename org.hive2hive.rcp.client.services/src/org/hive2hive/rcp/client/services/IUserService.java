package org.hive2hive.rcp.client.services;

import java.nio.file.Path;

import org.eclipse.e4.core.services.events.IEventBroker;

public interface IUserService {

	public final String USER_STATUS = "USER_STATUS";

	// logging in logged in logging
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
	
	public class StatusMessage{
		private final Status status;
		private final String message;
		public StatusMessage(Status status, String message) {
			this.status = status;
			this.message = message;
		}
		public Status getStatus() {
			return status;
		}
		public String getMessage() {
			return message;
		}
	}

	boolean registerUser(String userId, String password, String pin, IServiceListener listener);

	boolean loginUser(String userId, String password, String pin, Path rootDirectoryPath, IServiceListener listener);

	boolean isUserRegistered(String userId);

	void test(IEventBroker eventBroker);

	void registerAndLoginUser(String userId, String password, String pin, Path rootDirPath, IEventBroker eventBroker);

}
