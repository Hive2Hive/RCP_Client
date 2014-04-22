package org.hive2hive.rcp.client.services.internal;

import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.interfaces.IUserManager;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponent;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.hive2hive.core.security.UserCredentials;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IUserService;

public class H2HUserServiceImpl implements IUserService {

	@Override
	public boolean registerUser(INetworkConnectionService connectionService, String userId, String password,
			String pin, IProcessComponentListener listener) {
		IH2HNode node = connectionService.getCurrentNode();
		IUserManager userManager = node.getUserManager();
		UserCredentials credentials = new UserCredentials(userId, password, pin);
		try {
			IProcessComponent pc = userManager.register(credentials);
			pc.attachListener(listener);
		} catch (NoPeerConnectionException e) {
			e.printStackTrace();
		}
		return false;
	}

}
