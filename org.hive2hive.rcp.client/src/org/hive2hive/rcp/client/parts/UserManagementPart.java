package org.hive2hive.rcp.client.parts;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.miginfocom.swt.MigLayout;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.hive2hive.rcp.client.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserManagementPart {

	private static final Logger logger = LoggerFactory.getLogger(UserManagementPart.class);

	@Inject
	private IUserService userService;

	@Inject
	private IEventBroker eventBroker;

	private Text txtUserId_login;
	private Text txtPassword_login;
	private Text txtPin_login;
	private Text txtFileRoot;

	@PostConstruct
	public void createControls(final Composite parent) {
		logger.debug(this.getClass().getSimpleName() + " @PostConstruct method called.");

		MigLayout layout = new MigLayout("", "[][]", "[top]");
		parent.setLayout(layout);
		createLoginGroup(parent);

	}

	private void createLoginGroup(Composite parent) {
		final Group loginGroup = new Group(parent, SWT.SHADOW_NONE);
		MigLayout loginLayout = new MigLayout("wrap", "[right]5[left, 80!]5[40!, grow]", "");
		loginGroup.setLayout(loginLayout);
		loginGroup.setText("Login User");

		Label lblUserID = new Label(loginGroup, SWT.NONE);
		lblUserID.setText("User ID:");
		txtUserId_login = new Text(loginGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtUserId_login.setText("Mr. X");
		txtUserId_login.setLayoutData("grow, wrap");

		Label lblPassword = new Label(loginGroup, SWT.NONE);
		lblPassword.setText("Password:");
		txtPassword_login = new Text(loginGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPassword_login.setText("secret");
		txtPassword_login.setLayoutData("grow, wrap");

		Label lblPin = new Label(loginGroup, SWT.NONE);
		lblPin.setText("Pin:");
		txtPin_login = new Text(loginGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPin_login.setText("1234");
		txtPin_login.setLayoutData("grow, wrap");

		Label lblFileRoot = new Label(loginGroup, SWT.NONE);
		lblFileRoot.setText("File root:");

		Button btnFileRoot = new Button(loginGroup, SWT.PUSH);
		btnFileRoot.setText("Select");
		btnFileRoot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				DirectoryDialog directoryDialog = new DirectoryDialog(loginGroup.getShell(), SWT.OPEN);
				directoryDialog.setText("Open");
				String selected = directoryDialog.open();
				logger.debug(selected);
				if (selected != null) {
					txtFileRoot.setText(selected);
				}
			}
		});
		btnFileRoot.setLayoutData("right, wrap");

		txtFileRoot = new Text(loginGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtFileRoot.setLayoutData("grow, span");
		txtFileRoot.setText("/Users/Nendor/H2H/MrX");

		Button btnLoginUser = new Button(loginGroup, SWT.PUSH);
		btnLoginUser.setText("Login user");
		btnLoginUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				logger.debug("Login user started.");
				Path userDirPath = Paths.get(txtFileRoot.getText());
				userService.registerAndLoginUser(txtUserId_login.getText(), txtPassword_login.getText(),
						txtPin_login.getText(), userDirPath, eventBroker);
			}
		});
	}

}
