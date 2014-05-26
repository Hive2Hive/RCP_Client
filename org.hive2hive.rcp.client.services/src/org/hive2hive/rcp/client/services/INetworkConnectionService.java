package org.hive2hive.rcp.client.services;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IH2HNode;

public interface INetworkConnectionService {
	public final String NETWORK_CONNECTION_STATUS = "NETWORK_CONNECTION_STATUS";

	enum Status {
		CONNECTING_TO_NETWORK,
		CONNECTING_SUCCESSFULL,
		CONNECTING_FAILED,
		DISCONNECTING_FROM_NETWORK,
		DISCONNECTING_SUCCESSFULL,
		DISCONNECTING_FAILED
	}

	void createInitialNode(IServiceListener serviceListener);

	void createInitialNode(IEventBroker eventBroker);

	void bootstrapToNetwork(String ipAddress, String port, IServiceListener serviceListener);

	void bootstrapToNetwork(String ipAddress, String port, IEventBroker eventBroker);

	void disconnect(IServiceListener serviceListener);

	String getServiceTestMessage();

	IH2HNode getCurrentNode();
}
