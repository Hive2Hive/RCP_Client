package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.miginfocom.swt.MigLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.hive2hive.core.processes.framework.RollbackReason;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IUserService;

public class UserManagementPart {

	@Inject
	private IBundleResourceLoader resourceLoader;

	@Inject
	private INetworkConnectionService connectionService;

	@Inject
	private IUserService userService;

	private Text txtUserId_reg;
	private Text txtPassord_reg;
	private Text txtPin_reg;

	private Text txtUserId_login;
	private Text txtPassord_login;

	private ImageViewerCached registrationLoader;
	private ImageViewerCached loader;
	private boolean userRegistered = false;

	@PostConstruct
	public void createControls(final Composite parent) {
		System.out.println(this.getClass().getSimpleName() + " @PostConstruct method called.");

		MigLayout layout = new MigLayout("", "[][]", "[top]");
		parent.setLayout(layout);

		createUserRegistrationGroup(parent);

		createLoginGroup(parent);

		System.out.println("Testing the network connection service: "
				+ connectionService.getServiceTestMessage());

	}

	private void createLoginGroup(Composite parent) {
		Group loginGroup = new Group(parent, SWT.SHADOW_NONE);
		MigLayout loginLayout = new MigLayout("wrap", "[right]5[]", "");
		loginGroup.setLayout(loginLayout);
		loginGroup.setText("Login User");

		Label lblUserID = new Label(loginGroup, SWT.NONE);
		lblUserID.setText("User ID:");
		txtUserId_login = new Text(loginGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);

		Label lblPassword = new Label(loginGroup, SWT.NONE);
		lblPassword.setText("Password:");
		txtPassord_login = new Text(loginGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);

		final ImageData[] imageData = resourceLoader.loadImageData(this.getClass(), "images/loader.gif");

		loader = new ImageViewerCached(loginGroup);
		loader.setImage(imageData[0]);
		loader.setImages(imageData, 0);
		loader.setVisible(true);

		Button btnLoginUser = new Button(loginGroup, SWT.PUSH);
		btnLoginUser.setText("Login user");
		// btnLoginUser.setLayoutData("span");
		btnLoginUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO nendor: call login of service.
				loader.setVisible(!loader.getVisible());
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

		Label lblPassword = new Label(userRegistrationGroup, SWT.NONE);
		lblPassword.setText("Password:");
		txtPassord_reg = new Text(userRegistrationGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);

		Label lblPin = new Label(userRegistrationGroup, SWT.NONE);
		lblPin.setText("Pin:");
		txtPin_reg = new Text(userRegistrationGroup, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);

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
				System.out.println("registration loader visible = " + registrationLoader.isVisible());
				toggleRegistrationLoader();
				if (!userRegistered) {
					userService.registerUser(connectionService, txtUserId_reg.getText(), txtPassord_reg
							.getText(), txtPin_reg.getText(), new ProgressListener(registrationLoader));
				}
			}
		});
	}

	private void toggleRegistrationLoader() {
		registrationLoader.setVisible(!registrationLoader.getVisible());
	}

	private class ProgressListener implements IProcessComponentListener {

		private final ImageViewerCached viewer;

		public ProgressListener(ImageViewerCached viewer) {
			this.viewer = viewer;
		}

		@Override
		public void onSucceeded() {
			System.out.println("User creation sucessful.");
			userRegistered = true;
		}

		@Override
		public void onFinished() {
			System.out.println("User creation finished.");
			viewer.setVisible(false);
		}

		@Override
		public void onFailed(RollbackReason reason) {
			System.err.println("User creation failed for the following reason: " + reason);
		}
	}
}
