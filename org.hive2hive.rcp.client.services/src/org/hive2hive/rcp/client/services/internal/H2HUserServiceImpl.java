package org.hive2hive.rcp.client.services.internal;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.swt.widgets.Display;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.interfaces.IUserManager;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.processes.framework.RollbackReason;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponent;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.hive2hive.core.security.UserCredentials;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IServiceListener;
import org.hive2hive.rcp.client.services.IUserService;

public class H2HUserServiceImpl implements IUserService {

	@Override
	public boolean registerUser(INetworkConnectionService connectionService, String userId, String password,
			String pin, IServiceListener listener) {
		IH2HNode node = connectionService.getCurrentNode();
		IUserManager userManager = node.getUserManager();
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
	public boolean loginUser(INetworkConnectionService connectionService, String userId, String password,
			String pin, IServiceListener listener) {
		IH2HNode node = connectionService.getCurrentNode();
		IUserManager userManager = node.getUserManager();

		UserCredentials credentials = new UserCredentials(userId, password, pin);
		Path rootPath = Paths.get(System.getProperty("user.home"));

		try {
			IProcessComponent pc = userManager.login(credentials, rootPath);
			pc.attachListener(new ProcessComponentListenerWrapper(listener));
		} catch (NoPeerConnectionException e) {
			e.printStackTrace();
		}
		return false;
	}

	private class ProcessComponentListenerWrapper implements IProcessComponentListener {
		private final IServiceListener listener;

		public ProcessComponentListenerWrapper(IServiceListener listener) {
			this.listener = listener;
		}

		@Override
		public void onSucceeded() {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					listener.serviceSucceeded();
				}
			};
			executeAsync(runnable);
		}

		@Override
		public void onFailed(RollbackReason reason) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					listener.serviceFailed();
				}
			};
			executeAsync(runnable);
		}

		@Override
		public void onFinished() {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					listener.serviceFinished();
				}
			};

			executeAsync(runnable);

		}

		private void executeAsync(Runnable runnable) {
			Display.getDefault().asyncExec(runnable);
		}

	}

}
