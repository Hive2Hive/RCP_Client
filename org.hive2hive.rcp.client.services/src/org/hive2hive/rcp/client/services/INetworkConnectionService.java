package org.hive2hive.rcp.client.services;

import org.hive2hive.core.api.interfaces.IH2HNode;

public interface INetworkConnectionService {
	boolean createInitialNode();

	boolean bootstrapToNetwork(String ipAddress, String port);

	String getServiceTestMessage();

	IH2HNode getCurrentNode();
}
