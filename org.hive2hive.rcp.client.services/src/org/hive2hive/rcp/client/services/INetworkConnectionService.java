package org.hive2hive.rcp.client.services;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IH2HNode;

public interface INetworkConnectionService extends IService {
	public final String NETWORK_CONNECTION_STATUS = "NETWORK_CONNECTION_STATUS";

	enum Status {
		CONNECTING_TO_NETWORK,
		CONNECTING_SUCCESSFULL,
		CONNECTING_FAILED,
		DISCONNECTING_FROM_NETWORK,
		DISCONNECTING_SUCCESSFULL,
		DISCONNECTING_FAILED
	}

	void initNetworkConnectionService(IEventBroker eventBroker);

	void createInitialNode();

	void bootstrapToNetwork(String ipAddress, String port);

	void disconnect();

	IH2HNode getCurrentNode();
}
