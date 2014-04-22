package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.miginfocom.swt.MigLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.hive2hive.core.network.Connection;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPart {
	private static final String INITIAL_NODE_CREATION_LABEL = "Create initial node";
	private static final String CONNECT_TO_NODE_LABEL = "Connect";

	private static final Logger logger = LoggerFactory.getLogger(Connection.class);

	private Label lblConnectionAddress;
	private Text txtIpAddress;
	private Label lblConnectionSeparator;
	private Text txtPort;

	private Button btnCreateInitialNode;
	private Button btnConnectToNode;
	private Button btnConnect;

	@Inject
	private INetworkConnectionService networkConnectionService;

	@PostConstruct
	public void createControls(final Composite parent) {

		logger.debug("Create controls");

		MigLayout layout = new MigLayout("wrap", "[center][center]", "[]5[]5[]");
		parent.setLayout(layout);

		btnCreateInitialNode = new Button(parent, SWT.RADIO);
		btnCreateInitialNode.setText("Create initial node");
		btnCreateInitialNode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enableConnectionDetails(false);
				updateConnectionButton(INITIAL_NODE_CREATION_LABEL);
				btnConnect.setEnabled(true);
			}
		});

		btnConnectToNode = new Button(parent, SWT.RADIO);
		btnConnectToNode.setText("Connect to network node");
		btnConnectToNode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enableConnectionDetails(true);
				updateConnectionButton(CONNECT_TO_NODE_LABEL);
				updateConnectButton(txtIpAddress.getText(), txtPort.getText());
			}
		});

		Composite connectionAddressComposite = new Composite(parent, SWT.NONE);
		MigLayout connectionAddressLayout = new MigLayout("wrap", "[]4[]4[]4[]", "");
		connectionAddressComposite.setLayout(connectionAddressLayout);
		connectionAddressComposite.setLayoutData("span");

		lblConnectionAddress = new Label(connectionAddressComposite, SWT.NONE);
		lblConnectionAddress.setText("Connection address:");

		txtIpAddress = new Text(connectionAddressComposite, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtIpAddress.setLayoutData("width 120!");
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

		btnConnect = new Button(parent, SWT.PUSH);
		btnConnect.setText("Connect!");
		btnConnect.setLayoutData("span");
		btnConnect.setText(INITIAL_NODE_CREATION_LABEL);

		btnConnect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnCreateInitialNode.getSelection()) {
					networkConnectionService.createInitialNode();
				} else {
					if (connectionDataCorrect(txtIpAddress.getText(), txtPort.getText())) {
						networkConnectionService.bootstrapToNetwork(txtIpAddress.getText(), txtPort.getText());
					}
				}
			}

		});

		enableConnectionDetails(false);
		btnCreateInitialNode.setSelection(true);

	}

	private void enableConnectionDetails(boolean enabled) {
		lblConnectionAddress.setEnabled(enabled);
		txtIpAddress.setEnabled(enabled);
		lblConnectionSeparator.setEnabled(enabled);
		txtPort.setEnabled(enabled);
		lblConnectionAddress.getParent().update();
	}

	private void updateConnectionButton(String buttonLabel) {
		btnConnect.setText(buttonLabel);
		btnConnect.getParent().layout(true, true);
	}

	private boolean connectionDataCorrect(String ipAddress, String port) {
		return ipAddress.matches("(\\d{3}\\.){3}\\d{3}") && port.matches("\\d{4}");
	}

	private void updateConnectButton(String ipAddress, String port) {
		if (connectionDataCorrect(ipAddress, port)) {
			btnConnect.setEnabled(true);
		} else {
			btnConnect.setEnabled(false);
		}
	}

	private boolean isBackspaceOrDelete(char c) {
		return c == '\u0008' || c == '\u007F';
	}

}
