package org.hive2hive.rcp.client.services;

import org.hive2hive.core.api.interfaces.IH2HNode;

public interface INetworkConnectionService {
	void createInitialNode(IServiceListener serviceListener);

	void bootstrapToNetwork(String ipAddress, String port, IServiceListener serviceListener);

	void disconnect(IServiceListener serviceListener);

	String getServiceTestMessage();

	IH2HNode getCurrentNode();
}
