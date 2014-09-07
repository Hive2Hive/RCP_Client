package org.hive2hive.rcp.client.services.internal.process.user;

import java.nio.file.Path;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IUserManager;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.security.UserCredentials;
import org.hive2hive.processframework.exceptions.InvalidProcessStateException;
import org.hive2hive.processframework.exceptions.ProcessExecutionException;
import org.hive2hive.processframework.interfaces.IProcessComponent;
import org.hive2hive.rcp.client.model.filetree.User;
import org.hive2hive.rcp.client.services.IUserService;
import org.hive2hive.rcp.client.services.IUserService.Status;
import org.hive2hive.rcp.client.services.internal.process.ComponentCompletionWaiter;
import org.hive2hive.rcp.client.services.internal.process.ServiceProcessStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginProcessStep extends ServiceProcessStep {
	private static final Logger logger = LoggerFactory.getLogger(LoginProcessStep.class);

	private final String userId;
	private final String password;
	private final String pin;
	private final Path roodDirPath;

	private final IUserManager userManager;

	private final User user;

	public LoginProcessStep(String userId, String password, String pin, Path rootDirPath, IUserManager userManager,
			IEventBroker eventBroker, User user) {
		super(IUserService.USER_STATUS, eventBroker);
		this.userId = userId;
		this.password = password;
		this.pin = pin;
		this.roodDirPath = rootDirPath;
		this.userManager = userManager;
		this.user = user;
	}

	@Override
	protected void doExecute() throws InvalidProcessStateException, ProcessExecutionException {
		UserCredentials credentials = new UserCredentials(userId, password, pin);

		try {
			publishProcessState(Status.LOGGING_IN_USER, userId);
			IProcessComponent pc = userManager.login(credentials, roodDirPath);
			ComponentCompletionWaiter waiter = new ComponentCompletionWaiter();
			pc.attachListener(waiter);
			waiter.await();
			publishProcessState(Status.LOGIN_SUCCESSFUL);
			setUserFields();
		} catch (NoPeerConnectionException e) {
			publishProcessState(Status.LOGIN_FAILED);
			logger.error("Error while trying to log in user '{}'.", userId, e);
		}
	}

	private void setUserFields() {
		user.setUserId(userId);
		user.setPassword(password);
		user.setPin(pin);
		user.setRootDir(roodDirPath);
	}

}
