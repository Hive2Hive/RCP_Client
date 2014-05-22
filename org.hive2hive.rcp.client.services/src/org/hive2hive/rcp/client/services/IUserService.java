package org.hive2hive.rcp.client.services;

import java.nio.file.Path;

import org.eclipse.e4.core.services.events.IEventBroker;

public interface IUserService {

	public final String IUSERSERVICE_TEST = "IUSERSERVICE_TEST";

	boolean registerUser(String userId, String password, String pin, IServiceListener listener);

	boolean loginUser(String userId, String password, String pin, Path rootDirectoryPath, IServiceListener listener);

	boolean isUserRegistered(String userId);

	void test(IEventBroker eventBroker);

}
