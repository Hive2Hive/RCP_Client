package org.hive2hive.rcp.client.services.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.hive2hive.core.api.H2HNode;
import org.hive2hive.core.api.configs.FileConfiguration;
import org.hive2hive.core.api.configs.NetworkConfiguration;
import org.hive2hive.core.api.interfaces.IFileConfiguration;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.interfaces.INetworkConfiguration;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HNetworkConnectionService implements INetworkConnectionService {

	private IH2HNode node = null;

	private static final Logger logger = LoggerFactory.getLogger(H2HNetworkConnectionService.class);

	@Override
	public boolean createInitialNode() {
		logger.debug("Creating initial network node.");
		INetworkConfiguration initialNodeConfig = NetworkConfiguration.create("initialNodeID");
		IFileConfiguration defaultFileConfig = FileConfiguration.createDefault();

		node = H2HNode.createNode(initialNodeConfig, defaultFileConfig);
		node.connect();

		// TODO Nendor remove this once we solved the async issue...
		node.getUserManager().configureAutostart(false);
		node.getFileManager().configureAutostart(false);

		return true;
	}

	@Override
	public boolean bootstrapToNetwork(String ipAddress, String port) {
		System.out.println("Connecting to node with address " + ipAddress + ":" + port);
		INetworkConfiguration nodeConfig;
		try {
			nodeConfig = NetworkConfiguration.create("nodeID", InetAddress.getByName(ipAddress));
			IFileConfiguration defaultFileConfig = FileConfiguration.createDefault();

			node = H2HNode.createNode(nodeConfig, defaultFileConfig);
			node.connect();
			// TODO Nendor remove this once we solved the async issue...
			node.getUserManager().configureAutostart(false);
			node.getFileManager().configureAutostart(false);

			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getServiceTestMessage() {
		return "NetworkConnectionService OK.";
	}

	@Override
	public IH2HNode getCurrentNode() {
		return node;
	}

}
