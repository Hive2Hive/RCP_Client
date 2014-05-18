package org.hive2hive.rcp.client.services.internal;

import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

final class ServiceHelper {
	private static final ServiceHelper INSTANCE = new ServiceHelper();

	private final BundleContext bundleContext;

	private ServiceHelper() {
		bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getService(Class<T> clazz) throws ClassCastException {
		ServiceReference<?> serviceReference = INSTANCE.bundleContext.getServiceReference(INetworkConnectionService.class
				.getName());
		return (T) INSTANCE.bundleContext.getService(serviceReference);
	}

}
