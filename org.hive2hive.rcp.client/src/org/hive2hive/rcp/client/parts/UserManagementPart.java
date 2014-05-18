package org.hive2hive.rcp.client.parts;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.miginfocom.swt.MigLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.services.IUserService;
import org.hive2hive.rcp.client.services.ServiceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserManagementPart {

	private static final Logger logger = LoggerFactory.getLogger(UserManagementPart.class);

	@Inject
	private IBundleResourceLoader resourceLoader;

	@Inject
	private IUserService userService;

	private Text txtUserId_reg;
	private Text txtPassord_reg;
	private Text txtPin_reg;

	private Text txtUserId_login;
	private Text txtPassord_login;
	private Text txtPin_login;
	private Text txtFileRoot;

	private ImageViewerCached registrationLoader;
	private ImageViewerCached loader;
	private boolean userRegistered = false;

	@PostConstruct
	public void createControls(final Composite parent) {
		logger.debug(this.getClass().getSimpleName() + " @PostConstruct method called.");

		MigLayout layout = new MigLayout("", "[][]", "[top]");
		parent.setLayout(layout);

		createUserRegistrationGroup(parent);

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
		txtPassord_login = new Text(loginGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPassord_login.setText("secret");
		txtPassord_login.setLayoutData("grow, wrap");

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

		final ImageData[] imageData = resourceLoader.loadImageData(this.getClass(), "images/loader.gif");

		loader = new ImageViewerCached(loginGroup);
		loader.setImage(imageData[0]);
		loader.setImages(imageData, 0);
		loader.setVisible(false);

		Button btnLoginUser = new Button(loginGroup, SWT.PUSH);
		btnLoginUser.setText("Login user");
		// btnLoginUser.setLayoutData("span");
		btnLoginUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				loader.setVisible(true);
				Path userDirectoryPath = Paths.get(txtFileRoot.getText());
				userService.loginUser(txtUserId_login.getText(), txtPassord_login.getText(), txtPin_login.getText(),
						userDirectoryPath, new LoginUserListener());
			}
		});
	}

	private void createUserRegistrationGroup(final Composite parent) {
		Group userRegistrationGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
		MigLayout userRegistrationlayout = new MigLayout("wrap", "[right]5[]", "");
		userRegistrationGroup.setLayout(userRegistrationlayout);
		userRegistrationGroup.setText("User Registration");

		Label lblUserID = new Label(userRegistrationGroup, SWT.NONE);
		lblUserID.setText("User ID:");
		txtUserId_reg = new Text(userRegistrationGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtUserId_reg.setText("Mr. X");

		Label lblPassword = new Label(userRegistrationGroup, SWT.NONE);
		lblPassword.setText("Password:");
		txtPassord_reg = new Text(userRegistrationGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPassord_reg.setText("secret");

		Label lblPin = new Label(userRegistrationGroup, SWT.NONE);
		lblPin.setText("Pin:");
		txtPin_reg = new Text(userRegistrationGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPin_reg.setText("1234");

		final ImageData[] imageData = resourceLoader.loadImageData(this.getClass(), "images/loader.gif");

		registrationLoader = new ImageViewerCached(userRegistrationGroup);
		registrationLoader.setImage(imageData[0]);
		registrationLoader.setImages(imageData, 0);
		registrationLoader.setVisible(false);

		Button btnRegisterUser = new Button(userRegistrationGroup, SWT.PUSH);
		btnRegisterUser.setText("Register user");
		btnRegisterUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				toggleRegistrationLoader();
				if (!userRegistered) {
					userService.registerUser(txtUserId_reg.getText(), txtPassord_reg.getText(), txtPin_reg.getText(),
							new RegisterUserListener());
				}
			}
		});
	}

	private void toggleRegistrationLoader() {
		registrationLoader.setVisible(!registrationLoader.getVisible());
	}

	private class RegisterUserListener extends ServiceAdapter {

		@Override
		public void serviceFinished() {
			logger.debug("User creation finished.");
			toggleRegistrationLoader();
		}

		@Override
		public void serviceSucceeded() {
			logger.debug("User creation sucessful.");
			userRegistered = true;
		}

	}

	private class LoginUserListener extends ServiceAdapter {
		@Override
		public void serviceFinished() {
			logger.debug("User login service finished");
			loader.setVisible(!loader.isVisible());
		}

		@Override
		public void serviceSucceeded() {
			logger.debug("User login was successful.");
		}

		@Override
		public void serviceFailed() {
			logger.debug("Service failed!");
		}
	}

}
