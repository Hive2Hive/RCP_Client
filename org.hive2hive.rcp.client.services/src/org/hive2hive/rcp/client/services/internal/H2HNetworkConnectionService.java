package org.hive2hive.rcp.client.services.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.H2HNode;
import org.hive2hive.core.api.configs.FileConfiguration;
import org.hive2hive.core.api.configs.NetworkConfiguration;
import org.hive2hive.core.api.interfaces.IFileConfiguration;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.interfaces.INetworkConfiguration;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HNetworkConnectionService extends H2HService implements INetworkConnectionService {

	private static final Logger logger = LoggerFactory.getLogger(H2HNetworkConnectionService.class);

	private IH2HNode node = null;
	private IEventBroker eventBroker;

	@Override
	public void initNetworkConnectionService(IEventBroker eventBroker) {
		this.eventBroker = eventBroker;
	}

	@Override
	public void disconnect() {
		logger.debug("Disconnecting");
		eventBroker.post(INetworkConnectionService.NETWORK_CONNECTION_STATUS, Status.DISCONNECTING_FROM_NETWORK);
		if (node.disconnect()) {
			eventBroker.post(INetworkConnectionService.NETWORK_CONNECTION_STATUS, Status.DISCONNECTING_SUCCESSFULL);
		} else {
			eventBroker.post(INetworkConnectionService.NETWORK_CONNECTION_STATUS, Status.DISCONNECTING_FAILED);
		}
	}

	@Override
	public IH2HNode getCurrentNode() {
		return node;
	}

	@Override
	public void createInitialNode() {
		eventBroker.post(NETWORK_CONNECTION_STATUS, Status.CONNECTING_TO_NETWORK);
		logger.debug("Creating initial network node.");
		INetworkConfiguration initialNodeConfig = NetworkConfiguration.create("initialNodeID");
		IFileConfiguration defaultFileConfig = FileConfiguration.createDefault();
		node = H2HNode.createNode(initialNodeConfig, defaultFileConfig);
		boolean success = node.connect();
		if (success) {
			eventBroker.post(NETWORK_CONNECTION_STATUS, Status.CONNECTING_SUCCESSFULL);
		} else {
			eventBroker.post(NETWORK_CONNECTION_STATUS, Status.CONNECTING_FAILED);
		}
	}

	@Override
	public void bootstrapToNetwork(String ipAddress, String port) {
		eventBroker.post(NETWORK_CONNECTION_STATUS, Status.CONNECTING_TO_NETWORK);
		logger.debug("Connecting to node with address {}:{}", ipAddress, port);
		INetworkConfiguration nodeConfig;
		boolean success = false;
		try {
			// TODO Nendor: Set a correct node ID here
			nodeConfig = NetworkConfiguration.create("otherNode", InetAddress.getByName(ipAddress), Integer.parseInt(port));
			IFileConfiguration defaultFileConfig = FileConfiguration.createDefault();
			node = H2HNode.createNode(nodeConfig, defaultFileConfig);
			success = node.connect();
		} catch (UnknownHostException e) {
			logger.error("Error while bootstraping to network with address {}:{}", ipAddress, port, e);
		}
		if (success) {
			eventBroker.post(NETWORK_CONNECTION_STATUS, Status.CONNECTING_SUCCESSFULL);
		} else {
			eventBroker.post(NETWORK_CONNECTION_STATUS, Status.CONNECTING_FAILED);
		}
	}

}
