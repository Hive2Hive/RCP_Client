package org.hive2hive.rcp.client.services.internal.process.user;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IUserManager;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.processes.framework.exceptions.InvalidProcessStateException;
import org.hive2hive.core.processes.framework.exceptions.ProcessExecutionException;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponent;
import org.hive2hive.core.security.UserCredentials;
import org.hive2hive.rcp.client.services.IUserService;
import org.hive2hive.rcp.client.services.internal.process.ComponentCompletionWaiter;
import org.hive2hive.rcp.client.services.internal.process.ServiceProcessStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterProcessStep extends ServiceProcessStep {

	private final String userId;
	private final String password;
	private final String pin;

	private final IUserManager userManager;

	public RegisterProcessStep(String userId, String password, String pin, IEventBroker eventBroker, IUserManager userManager) {
		super(IUserService.USER_STATUS, eventBroker);
		this.userId = userId;
		this.password = password;
		this.pin = pin;
		this.userManager = userManager;
	}

	private final Logger logger = LoggerFactory.getLogger(RegisterProcessStep.class);

	@Override
	protected void doExecute() throws InvalidProcessStateException, ProcessExecutionException {

		try {
			publishProcessState(IUserService.Status.REGISTERING_USER);
			if (!userManager.isRegistered(userId)) {
				logger.debug("Starting user registration");
				publishProcessState("Registering user " + userId);
				UserCredentials credentials = new UserCredentials(userId, password, pin);
				IProcessComponent pc = userManager.register(credentials);
				ComponentCompletionWaiter waiter = new ComponentCompletionWaiter();
				pc.attachListener(waiter);
				waiter.await();
				logger.debug("Registration successful");
			} else {
				logger.debug("User {} is already registered - nothing to do here.", userId);
			}
			publishProcessState(IUserService.Status.REGISTER_SUCCESSFULL);
		} catch (NoPeerConnectionException e) {
			publishProcessState(IUserService.Status.RESISTER_FAILED);
			logger.error("Error while trying to register user '{}'.", userId, e);
		}

	}

}