package org.hive2hive.rcp.client.services;


public interface IUserService {

	boolean registerUser(INetworkConnectionService connectionService, String userId, String password,
			String pin, IServiceListener listener);

}
