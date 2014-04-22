package org.hive2hive.rcp.client.services;

import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;

public interface IUserService {

	boolean registerUser(INetworkConnectionService connectionService, String userId, String password,
			String pin, IProcessComponentListener listener);

}
