package org.hive2hive.rcp.client.handler.dialog;

import net.miginfocom.swt.MigLayout;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO Nendor: Field validation
public class UserLoginDialog extends TitleAreaDialog {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginDialog.class);

	private static final String LOGING_BUTTON_LABEL = "Login User";

	private final IBundleResourceLoader resourceLoader;

	private Text txtUserId;
	private Text txtPassword;
	private Text txtPin;
	private Text txtFileRoot;

	private Button btnFileRoot;

	private String userId;
	private String password;
	private String pin;
	private String fileRoot;

	public UserLoginDialog(Shell parentShell, IBundleResourceLoader resourceLoader) {
		super(parentShell);
		this.resourceLoader = resourceLoader;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		getTitleImageLabel().setImage(resourceLoader.loadImage(this.getClass(), "images/user/64x64/login64x64.png"));

		Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);

		MigLayout layout = new MigLayout("wrap", "[][][]", "[]5[]5[]5[]");
		container.setLayout(layout);

		Label lblUserId = new Label(container, SWT.NONE);
		lblUserId.setText("User ID:");
		txtUserId = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtUserId.setLayoutData("width 200::, wrap");
		txtUserId.setText("Mr. X");

		Label lblPassowrd = new Label(container, SWT.NONE);
		lblPassowrd.setText("Password:");
		txtPassword = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPassword.setLayoutData("width 100::, wrap");
		txtPassword.setText("password");

		Label lblPin = new Label(container, SWT.NONE);
		lblPin.setText("Pin:");
		txtPin = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtPin.setLayoutData("width 80::, wrap");
		txtPin.setText("1234");

		Label lblFileRootPath = new Label(container, SWT.NONE);
		lblFileRootPath.setText("File Root:");
		txtFileRoot = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtFileRoot.setLayoutData("width 300::");
		txtFileRoot.setEnabled(false);
		txtFileRoot.setText("/Users/Nendor/H2H/MrX");

		btnFileRoot = new Button(container, SWT.PUSH);
		btnFileRoot.setText("select");
		btnFileRoot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog directoryDialog = new DirectoryDialog(container.getShell(), SWT.OPEN);
				directoryDialog.setText("File Root Selection");
				String selected = directoryDialog.open();
				logger.debug(selected);
				if (selected != null) {
					txtFileRoot.setText(selected);
				}

			}
		});

		return area;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, LOGING_BUTTON_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {
		persistsFields();
		super.okPressed();
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getPin() {
		return pin;
	}

	public String getFileRoot() {
		return fileRoot;
	}

	private void persistsFields() {
		userId = txtUserId.getText();
		password = txtPassword.getText();
		pin = txtPin.getText();
		fileRoot = txtFileRoot.getText();
	}

}
