package org.hive2hive.rcp.client.services.internal.process.network;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.processes.framework.exceptions.InvalidProcessStateException;
import org.hive2hive.core.processes.framework.exceptions.ProcessExecutionException;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.internal.process.ServiceProcessStep;

public class ConnectingToNetworkStep extends ServiceProcessStep {

	public ConnectingToNetworkStep(IEventBroker eventBroker) {
		super(INetworkConnectionService.NETWORK_CONNECTION_STATUS, eventBroker);
	}

	@Override
	protected void doExecute() throws InvalidProcessStateException, ProcessExecutionException {
		// TODO Auto-generated method stub

	}

}
