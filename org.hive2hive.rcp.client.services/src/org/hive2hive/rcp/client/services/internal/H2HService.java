package org.hive2hive.rcp.client.services.internal;

import org.hive2hive.core.processes.framework.abstracts.Process;
import org.hive2hive.core.processes.framework.decorators.AsyncComponent;
import org.hive2hive.core.processes.framework.exceptions.InvalidProcessStateException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class H2HService {

	private static final Logger logger = LoggerFactory.getLogger(H2HService.class);

	private static final BundleContext bundleContext = FrameworkUtil.getBundle(H2HService.class).getBundleContext();

	protected void runProcessAsynchronously(Process process) {
		AsyncComponent asynchronousComponent = new AsyncComponent(process);
		try {
			asynchronousComponent.start();
		} catch (InvalidProcessStateException e) {
			logger.error("Can't start Process.", e);
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> T getService(Class<T> clazz) throws ClassCastException {
		ServiceReference<?> serviceReference = bundleContext.getServiceReference(clazz.getName());
		return (T) bundleContext.getService(serviceReference);
	}

}
