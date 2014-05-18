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
import org.hive2hive.rcp.client.services.IServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HNetworkConnectionService implements INetworkConnectionService {

	private IH2HNode node = null;

	private static final Logger logger = LoggerFactory.getLogger(H2HNetworkConnectionService.class);

	@Override
	public void createInitialNode(IServiceListener serviceListener) {
		logger.debug("Creating initial network node.");
		INetworkConfiguration initialNodeConfig = NetworkConfiguration.create("initialNodeID");
		IFileConfiguration defaultFileConfig = FileConfiguration.createDefault();
		node = H2HNode.createNode(initialNodeConfig, defaultFileConfig);

		connectAndInformListener(serviceListener);
	}

	@Override
	public void bootstrapToNetwork(String ipAddress, String port, IServiceListener serviceListener) {
		logger.debug("Connecting to node with address {}:{}", ipAddress, port);
		INetworkConfiguration nodeConfig;
		try {
			nodeConfig = NetworkConfiguration.create("otherNode", InetAddress.getByName(ipAddress), Integer.parseInt(port));
			IFileConfiguration defaultFileConfig = FileConfiguration.createDefault();
			node = H2HNode.createNode(nodeConfig, defaultFileConfig);

			connectAndInformListener(serviceListener);

		} catch (UnknownHostException e) {
			serviceListener.serviceFinished();
			serviceListener.serviceFailed();
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect(IServiceListener serviceListener) {
		logger.debug("Disconnecting");
		disconnectAndInformListener(serviceListener);
	}

	@Override
	public String getServiceTestMessage() {
		return "NetworkConnectionService OK.";
	}

	@Override
	public IH2HNode getCurrentNode() {
		return node;
	}

	private void connectAndInformListener(IServiceListener serviceListener) {
		boolean connectionSuccess = node.connect();
		serviceListener.serviceFinished();
		if (connectionSuccess) {
			serviceListener.serviceSucceeded();
			logger.debug("Peeraddress: {}", node.getPeer().getPeerAddress());
		} else {
			serviceListener.serviceFailed();
		}
	}

	private void disconnectAndInformListener(IServiceListener serviceListener) {
		boolean disconnectionSuccess = node.disconnect();
		serviceListener.serviceFinished();
		if (disconnectionSuccess) {
			serviceListener.serviceSucceeded();
		} else {
			serviceListener.serviceFailed();
		}
	}

}
