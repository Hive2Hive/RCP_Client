package org.hive2hive.rcp.client.handler.dialog;

import net.miginfocom.swt.MigLayout;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectingToNetworkDialog extends TitleAreaDialog {

	private static final String INITIAL_NODE_CREATION_LABEL = "Create initial node";
	private static final String CONNECT_TO_NODE_LABEL = "Connect to network";

	private static final Logger logger = LoggerFactory.getLogger(ConnectingToNetworkDialog.class);

	private final IBundleResourceLoader resourceLoader;

	private Label lblConnectionAddress;
	private Text txtIpAddress;
	private Label lblConnectionSeparator;
	private Text txtPort;

	private Button btnCreateInitialNode;
	private Button btnConnectToNode;

	public ConnectingToNetworkDialog(Shell parentShell, IBundleResourceLoader resourceLoader) {
		super(parentShell);
		this.resourceLoader = resourceLoader;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		getTitleImageLabel().setImage(resourceLoader.loadImage(this.getClass(), "images/connection/64x64/connect64x64.png"));

		// TODO Nendor: Adjust user information.
		// Which type of peer creation (initial vs. bootstrapping)
		// Input errors (IP-address or port)
		setMessage("Connecting to network");

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);

		logger.debug("Create controls");

		MigLayout layout = new MigLayout("wrap", "[15!][]", "[]5[]");
		container.setLayout(layout);

		btnCreateInitialNode = new Button(container, SWT.RADIO);
		btnCreateInitialNode.setText("Create initial node");
		btnCreateInitialNode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enableConnectionDetails(false);
				updateConnectionButtonLabel(INITIAL_NODE_CREATION_LABEL);
				getConnectButton().setEnabled(true);
			}
		});
		btnCreateInitialNode.setLayoutData("span");

		btnConnectToNode = new Button(container, SWT.RADIO);
		btnConnectToNode.setText("Connect to network node");
		btnConnectToNode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enableConnectionDetails(true);
				updateConnectionButtonLabel(CONNECT_TO_NODE_LABEL);
				updateConnectButton(txtIpAddress.getText(), txtPort.getText());
			}
		});
		btnConnectToNode.setLayoutData("span");
		btnCreateInitialNode.setSelection(true);

		Composite connectionAddressComposite = createConnectionAddressComposite(container);
		connectionAddressComposite.setLayoutData("skip");
		return area;

	}

	private Composite createConnectionAddressComposite(Composite parent) {
		final Group connectionAddressComposite = new Group(parent, SWT.SHADOW_NONE);
		MigLayout connectionAddressLayout = new MigLayout("insets 2 2 2 2, wrap", "[]4[]4[]4[]", "");
		connectionAddressComposite.setLayout(connectionAddressLayout);

		lblConnectionAddress = new Label(connectionAddressComposite, SWT.NONE);
		lblConnectionAddress.setText("Connection address:");

		txtIpAddress = new Text(connectionAddressComposite, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtIpAddress.setLayoutData("width 120!");
		txtIpAddress.setText("127.000.000.001");
		txtIpAddress.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {
				if (!e.text.isEmpty()) {
					String newText = txtIpAddress.getText() + e.text;
					if (!newText.matches("(\\d{3}\\.?){0,3}\\d{0,3}")) {
						e.doit = false;
					} else {
						if (newText.matches("(\\d{3}\\.){0,2}\\d{3}")) {
							e.text += ".";
						} else if (newText.matches("(\\d{3}\\.)*\\d{4}")) {
							e.text = "." + e.text;
						}
					}
					updateConnectButton(newText, txtPort.getText());
				} else if (isBackspaceOrDelete(e.character)) {
					// backspace or delte
					updateConnectButton("", "");
				}
			}

		});

		lblConnectionSeparator = new Label(connectionAddressComposite, SWT.NONE);
		lblConnectionSeparator.setText(":");

		txtPort = new Text(connectionAddressComposite, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPort.setLayoutData("width 40!");
		txtPort.setText("4622");
		txtPort.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {
				String newText = txtPort.getText() + e.text;
				if (!e.text.isEmpty()) {
					if (!newText.matches("\\d{1,4}")) {
						e.doit = false;
					}
					updateConnectButton(txtIpAddress.getText(), newText);
				} else if (isBackspaceOrDelete(e.character)) {
					// backspace or delte
					updateConnectButton("", "");
				}
			}
		});
		enableConnectionDetails(false);
		return connectionAddressComposite;
	}

	private void enableConnectionDetails(boolean enabled) {
		lblConnectionAddress.setEnabled(enabled);
		txtIpAddress.setEnabled(enabled);
		lblConnectionSeparator.setEnabled(enabled);
		txtPort.setEnabled(enabled);
		lblConnectionAddress.getParent().update();
	}

	private void updateConnectionButtonLabel(String buttonLabel) {
		getConnectButton().setText(buttonLabel);
		getConnectButton().getParent().layout(true, true);
	}

	private boolean connectionDataCorrect(String ipAddress, String port) {
		return ipAddress.matches("(\\d{3}\\.){3}\\d{3}") && port.matches("\\d{4}");
	}

	private void updateConnectButton(String ipAddress, String port) {
		if (connectionDataCorrect(ipAddress, port)) {
			getConnectButton().setEnabled(true);
		} else {
			getConnectButton().setEnabled(false);
		}
	}

	private boolean isBackspaceOrDelete(char c) {
		return c == '\u0008' || c == '\u007F';
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, INITIAL_NODE_CREATION_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	private Button getConnectButton() {
		return getButton(IDialogConstants.OK_ID);
	}

	public String getIpAddress() {
		return txtIpAddress.getText();
	}

	public String getPort() {
		return txtPort.getText();
	}

	public boolean isCreateInitialNodeSelected() {
		return true;
	}
}
