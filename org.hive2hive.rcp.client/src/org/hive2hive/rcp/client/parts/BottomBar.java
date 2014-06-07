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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IService;
import org.hive2hive.rcp.client.services.IUserService;

public class BottomBar {

	private static final String CONNECT_TO_NETWORK_COMMAND_ID = "org.hive2hive.rcp.client.command.network.connect";
	private static final String DISCONNECT_TO_NETWORK_COMMAND_ID = "org.hive2hive.rcp.client.command.network.disconnect";

	private static final String LOGIN_USER_COMMAND_ID = "org.hive2hive.rcp.client.command.user.login";
	private static final String LOGOUT_USER_COMMAND_ID = "org.hive2hive.rcp.client.command.usesr.logout";

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
	public void createControlls(Composite parent) {

		MigLayout layout = new MigLayout("insets 1 1 1 1", "[][][][grow]", "[]");
		parent.setLayout(layout);

		createConnectionControlls(parent);
		createUserControlls(parent);
		createProgressInformationControlls(parent);
	}

	private void createConnectionControlls(Composite parent) {
		lblConnection = new Label(parent, SWT.NONE);
		lblConnection.setImage(bundleResourceLoader.loadImage(this.getClass(),
				"images/connection/32x32/disconnected32x32.png"));

		Menu m = new Menu(parent);
		buildConnectMenuItem(m);
		buildDisconnectMenuItem(m);
		lblConnection.setMenu(m);

	}

	private void createUserControlls(Composite parent) {
		lblUser = new Label(parent, SWT.NONE);
		lblUser.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/user/32x32/loggedout32x32.png"));
		Menu m = new Menu(parent);
		buildLoginMenuItem(m);
		buildLogoutMenuItem(m);
		lblUser.setMenu(m);
	}

	private void buildLoginMenuItem(Menu m) {
		buildMenuItem(m, LOGIN_USER_COMMAND_ID, "Login user", "images/user/16x16/login16x16.png");
	}

	private void buildLogoutMenuItem(Menu m) {
		buildMenuItem(m, LOGOUT_USER_COMMAND_ID, "Logout user", "images/user/16x16/logout16x16.png");
	}

	private void buildMenuItem(Menu m, final String commandId, final String label, final String imagePath) {
		MenuItem connectMenuItem = new MenuItem(m, SWT.PUSH);

		connectMenuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Command command = commandService.getCommand(commandId);
				ParameterizedCommand pc = ParameterizedCommand.generateCommand(command, null);
				handlerService.canExecute(pc, context);
				handlerService.executeHandler(pc, context);
			}
		});
		connectMenuItem.setText(label);
		connectMenuItem.setImage(bundleResourceLoader.loadImage(this.getClass(), imagePath));

	}

	private void buildConnectMenuItem(Menu m) {
		buildMenuItem(m, CONNECT_TO_NETWORK_COMMAND_ID, "Connect to network", "images/connection/16x16/connect16x16.png");
	}

	private void buildDisconnectMenuItem(Menu m) {
		buildMenuItem(m, DISCONNECT_TO_NETWORK_COMMAND_ID, "Disonnect from network",
				"images/connection/16x16/disconnect16x16.png");
	}

	private void createProgressInformationControlls(Composite parent) {
		final ImageData[] imageData = bundleResourceLoader.loadImageData(this.getClass(), "images/loader.gif");
		progressSymbol = new ImageViewerCached(parent);
		progressSymbol.setImage(imageData[0]);
		progressSymbol.setImages(imageData, 0);
		progressSymbol.setVisible(false);

		lblProgressMessage = new Label(parent, SWT.NONE);
		lblProgressMessage.setLayoutData("growx");
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
			case DISCONNECTING_FROM_NETWORK:
				lblConnection.setImage(resourceLoader.loadImage(this.getClass(),
						"images/connection/32x32/disconnect32x32.png"));
				showProgressInfo("Disconnecting from network");
				break;
			case DISCONNECTING_SUCCESSFULL:
				lblConnection.setImage(resourceLoader.loadImage(this.getClass(),
						"images/connection/32x32/disconnected32x32.png"));
				hideProgressInfo();
				break;
			case DISCONNECTING_FAILED:
				lblConnection.setImage(resourceLoader.loadImage(this.getClass(),
						"images/connection/32x32/connected32x32.png"));
				hideProgressInfo();
				break;
		}

	}

	@Inject
	@Optional
	private void handleUserStatus(@UIEventTopic(IUserService.USER_STATUS) IUserService.StatusMessage statusMessage,
			IBundleResourceLoader resourceLoader) {
		switch (statusMessage.getStatus()) {
			case REGISTERING_USER:
				showProgressInfo(String.format("Registering user '%s'", statusMessage.getMessage()));
				break;
			case REGISTER_SUCCESSFULL:
			case RESISTER_FAILED:
				hideProgressInfo();
				break;
			case LOGGING_IN_USER:
				showProgressInfo(String.format("Logging in user '%s'", statusMessage.getMessage()));
				lblUser.setImage(resourceLoader.loadImage(this.getClass(), "images/user/32x32/login32x32.png"));
				break;
			case LOGIN_SUCCESSFUL:
				lblUser.setImage(resourceLoader.loadImage(this.getClass(), "images/user/32x32/loggedin32x32.png"));
				hideProgressInfo();
				break;
			case LOGIN_FAILED:
				lblUser.setImage(resourceLoader.loadImage(this.getClass(), "images/user/32x32/loggedout32x32.png"));
				hideProgressInfo();
				break;
			case LOGGING_OUT_USER:
				lblUser.setImage(resourceLoader.loadImage(this.getClass(), "images/user/32x32/logout32x32.png"));
				showProgressInfo("Logging out user");
				break;
			case LOGOUT_SUCCESSFULL:
				lblUser.setImage(resourceLoader.loadImage(this.getClass(), "images/user/32x32/loggedout32x32.png"));
				hideProgressInfo();
				break;
			case LOGOUT_FAILED:
				lblUser.setImage(resourceLoader.loadImage(this.getClass(), "images/user/32x32/loggedin32x32.png"));
				hideProgressInfo();
				break;
		}
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
	private void displayServiceError(Shell shell, @UIEventTopic(IService.SERVICE_ERROR) String errorMessage) {
		MessageDialog.openError(shell, "Exception", errorMessage);
	}

}
