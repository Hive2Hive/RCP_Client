package org.hive2hive.rcp.client.services.internal;

import java.nio.file.Path;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.interfaces.IUserManager;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.processes.framework.concretes.SequentialProcess;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponent;
import org.hive2hive.core.security.UserCredentials;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IServiceListener;
import org.hive2hive.rcp.client.services.IUserService;
import org.hive2hive.rcp.client.services.internal.process.user.LoginProcessStep;
import org.hive2hive.rcp.client.services.internal.process.user.RegisterProcessStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HUserServiceImpl extends H2HService implements IUserService {

	static final Logger logger = LoggerFactory.getLogger(H2HUserServiceImpl.class);

	@Override
	public boolean registerUser(String userId, String password, String pin, IServiceListener listener) {
		IUserManager userManager = getUserManager();
		UserCredentials credentials = new UserCredentials(userId, password, pin);
		try {
			IProcessComponent pc = userManager.register(credentials);
			pc.attachListener(new ProcessComponentListenerWrapper(listener));
		} catch (NoPeerConnectionException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean loginUser(String userId, String password, String pin, Path rootDirectoryPath, IServiceListener listener) {
		IUserManager userManager = getUserManager();

		UserCredentials credentials = new UserCredentials(userId, password, pin);

		try {
			IProcessComponent pc = userManager.login(credentials, rootDirectoryPath);
			pc.attachListener(new ProcessComponentListenerWrapper(listener));
		} catch (NoPeerConnectionException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void test(IEventBroker eventBroker) {
		logger.debug("method 'test' called.");
	}

	@Override
	public boolean isUserRegistered(String userId) {
		try {
			return getUserManager().isRegistered(userId);
		} catch (NoPeerConnectionException e) {
			logger.error("Can't check if user is registered.", e);
		}
		return false;
	}

	private IUserManager getUserManager() {
		INetworkConnectionService connectionService = getService(INetworkConnectionService.class);
		IH2HNode node = connectionService.getCurrentNode();
		IUserManager userManager = node.getUserManager();
		return userManager;
	}

	@Override
	public void registerAndLoginUser(String userId, String password, String pin, Path rootDirPath, IEventBroker eventBroker) {
		SequentialProcess p = new SequentialProcess();
		p.add(new RegisterProcessStep(userId, password, pin, eventBroker, getUserManager()));
		p.add(new LoginProcessStep(userId, password, pin, rootDirPath, getUserManager(), eventBroker));
		runProcessAsynchronously(p);
	}

}
