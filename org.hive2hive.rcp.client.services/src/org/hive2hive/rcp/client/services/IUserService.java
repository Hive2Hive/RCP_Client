package org.hive2hive.rcp.client.services;

import java.nio.file.Path;

public interface IUserService {

	boolean registerUser(String userId, String password, String pin, IServiceListener listener);

	boolean loginUser(String userId, String password, String pin, Path rootDirectoryPath, IServiceListener listener);

	void test();

}
