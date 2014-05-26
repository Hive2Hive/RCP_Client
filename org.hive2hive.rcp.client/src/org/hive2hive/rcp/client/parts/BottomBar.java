package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.miginfocom.swt.MigLayout;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.events.ConnectionStatus;
import org.hive2hive.rcp.client.events.EventConstatns;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.ServiceConstants;

public class BottomBar {

	private static final String CONNECT_TO_NETWORK_COMMAND_ID = "org.hive2hive.rcp.client.network.connect";
	private static final String DISCONNECT_TO_NETWORK_COMMAND_ID = "org.hive2hive.rcp.client.network.disconnect";

	private Label lblConnection;
	private Label lblUser;
	private ImageViewerCached progressSymbol;
	private Label lblProgressMessage;

	@Inject
	private IBundleResourceLoader bundleResourceLoader;

	@Inject
	private EHandlerService handlerService;

	@Inject
	private ECommandService commandService;

	@Inject
	private IEclipseContext context;

	@PostConstruct
	public void createControlls(Composite parent, IBundleResourceLoader resourceLoader) {

		MigLayout layout = new MigLayout("insets 1 1 1 1", "[][][][grow]", "[]");
		parent.setLayout(layout);

		createConnectionControlls(parent);

		lblUser = new Label(parent, SWT.NONE);
		lblUser.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/User_32x32.png"));

		Menu m = new Menu(parent);
		MenuItem mi = new MenuItem(m, SWT.PUSH);

		mi.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Command command = commandService.getCommand(CONNECT_TO_NETWORK_COMMAND_ID);
				ParameterizedCommand pc = ParameterizedCommand.generateCommand(command, null);
				handlerService.canExecute(pc, context);
				handlerService.executeHandler(pc, context);
			}
		});
		mi.setText("Test Menu entry");

		lblUser.setMenu(m);

		createProgressInformationControlls(parent, resourceLoader);
	}

	void createConnectionControlls(Composite parent) {
		lblConnection = new Label(parent, SWT.NONE);
		lblConnection.setImage(bundleResourceLoader.loadImage(this.getClass(),
				"images/connection/32x32/disconnected32x32.png"));

		Menu m = new Menu(parent);
		buildConnectMenuItem(m);
		buildDisconnectMenuItem(m);
		lblConnection.setMenu(m);

	}

	private void buildConnectMenuItem(Menu m) {
		MenuItem connectMenuItem = new MenuItem(m, SWT.PUSH);

		connectMenuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Command command = commandService.getCommand(CONNECT_TO_NETWORK_COMMAND_ID);
				ParameterizedCommand pc = ParameterizedCommand.generateCommand(command, null);
				handlerService.canExecute(pc, context);
				handlerService.executeHandler(pc, context);
			}
		});
		connectMenuItem.setText("Connect to network");
		connectMenuItem
				.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/connection/16x16/connect16x16.png"));
	}

	private void buildDisconnectMenuItem(Menu m) {
		MenuItem connectMenuItem = new MenuItem(m, SWT.PUSH);

		connectMenuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Command command = commandService.getCommand(DISCONNECT_TO_NETWORK_COMMAND_ID);
				ParameterizedCommand pc = ParameterizedCommand.generateCommand(command, null);
				handlerService.canExecute(pc, context);
				handlerService.executeHandler(pc, context);
			}
		});
		connectMenuItem.setText("Disonnect from network");
		connectMenuItem.setImage(bundleResourceLoader.loadImage(this.getClass(),
				"images/connection/16x16/disconnect16x16.png"));
	}

	private void createProgressInformationControlls(Composite parent, IBundleResourceLoader resourceLoader) {
		final ImageData[] imageData = resourceLoader.loadImageData(this.getClass(), "images/loader.gif");
		progressSymbol = new ImageViewerCached(parent);
		progressSymbol.setImage(imageData[0]);
		progressSymbol.setImages(imageData, 0);
		progressSymbol.setVisible(false);

		lblProgressMessage = new Label(parent, SWT.NONE);
		lblProgressMessage.setLayoutData("growx");
	}

	@Inject
	@Optional
	public void updateConnection(@UIEventTopic(EventConstatns.CONNECTION_STATUS) ConnectionStatus connectionStatus) {
		switch (connectionStatus) {
			case DISCONNECTED:
				lblConnection.setImage(bundleResourceLoader.loadImage(this.getClass(),
						"images/Connection_disabled_32x32.png"));
				break;
			case CONNECTED:
				lblConnection.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/Connection_32x32.png"));
				break;
		}
	}

	@Inject
	@Optional
	private void handleServiceStateEvent(@UIEventTopic(ServiceConstants.SERVICE_STATE) String message) {
		if (message != null && !message.isEmpty()) {
			showProgressInfo(message);
		}
	}

	@Inject
	@Optional
	private void handleServiceFinishedEvent(@UIEventTopic(ServiceConstants.SERVICE_FINISHED) String message) {
		hideProgressInfo();
	}

	private void showProgressInfo(String info) {
		progressSymbol.setVisible(true);
		lblProgressMessage.setText(info);
	}

	private void hideProgressInfo() {
		progressSymbol.setVisible(false);
		lblProgressMessage.setText("");
	}

	@Inject
	@Optional
	private void handleNetworkConnectionStatus(
			@UIEventTopic(INetworkConnectionService.NETWORK_CONNECTION_STATUS) INetworkConnectionService.Status status,
			IBundleResourceLoader resourceLoader) {
		switch (status) {
			case CONNECTING_TO_NETWORK:
				lblConnection
						.setImage(resourceLoader.loadImage(this.getClass(), "images/connection/32x32/connect32x32.png"));
				showProgressInfo("Connecting to network");
				break;
			case CONNECTING_SUCCESSFULL:
				lblConnection.setImage(resourceLoader.loadImage(this.getClass(),
						"images/connection/32x32/connected32x32.png"));
				hideProgressInfo();
				break;
			case CONNECTING_FAILED:
				lblConnection.setImage(resourceLoader.loadImage(this.getClass(),
						"images/connection/32x32/disconnected32x32.png"));
				hideProgressInfo();
				break;
		}

	}

}
