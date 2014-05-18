package org.hive2hive.rcp.client.services.internal;

import java.nio.file.Path;

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
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HUserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(H2HUserServiceImpl.class);

	@Override
	public boolean registerUser(String userId, String password, String pin, IServiceListener listener) {
		INetworkConnectionService connectionService = ServiceHelper.getService(INetworkConnectionService.class);
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
	public boolean loginUser(String userId, String password, String pin, Path rootDirectoryPath, IServiceListener listener) {
		INetworkConnectionService connectionService = ServiceHelper.getService(INetworkConnectionService.class);
		IH2HNode node = connectionService.getCurrentNode();
		IUserManager userManager = node.getUserManager();

		UserCredentials credentials = new UserCredentials(userId, password, pin);

		try {
			IProcessComponent pc = userManager.login(credentials, rootDirectoryPath);
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
					listener.serviceFinished();
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
					listener.serviceFinished();
					listener.serviceFailed();
				}
			};
			executeAsync(runnable);
		}

		private void executeAsync(Runnable runnable) {
			Display.getDefault().asyncExec(runnable);
		}

	}

	@Override
	public void test() {
		logger.debug("method 'test' called.");
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference<?> serviceReference = bundleContext.getServiceReference(INetworkConnectionService.class.getName());
		INetworkConnectionService service = (INetworkConnectionService) bundleContext.getService(serviceReference);
		logger.debug("Try to get the connectionService. it is: {}", service);
		logger.debug("Try to access current node: {}", service.getCurrentNode());

		INetworkConnectionService s = ServiceHelper.getService(INetworkConnectionService.class);
		logger.debug("Service over helper: {}", s);
	}

}
