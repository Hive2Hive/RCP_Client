package org.hive2hive.rcp.client.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.handler.dialog.ConnectingToNetworkDialog;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkConnectHandler {

	private static final Logger logger = LoggerFactory.getLogger(NetworkConnectHandler.class);

	@CanExecute
	public boolean canExecue(INetworkConnectionService networkConnectionService) {
		boolean canExecute = true;
		if (networkConnectionService.getCurrentNode() != null) {
			canExecute = !networkConnectionService.getCurrentNode().isConnected();
		}
		logger.debug("Was asked if can be executed, return [{}]", canExecute);
		return canExecute;
	}

	@Execute
	public void execute(Shell shell, INetworkConnectionService networkConnectionService, IBundleResourceLoader resourceLoader) {
		logger.debug("Connecting to the network now.");
		ConnectingToNetworkDialog dialog = new ConnectingToNetworkDialog(shell, resourceLoader);
		if (dialog.open() == IDialogConstants.OK_ID) {
			logger.debug("Connect was pressed");
			networkConnectionService.createInitialNode(null);
		} else {
			logger.debug("Cancel was pressed");
		}

	}

}
