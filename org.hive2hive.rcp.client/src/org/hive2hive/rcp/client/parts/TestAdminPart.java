package org.hive2hive.rcp.client.parts;

import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IUserService;

public class TestAdminPart {

	private Button btnCreateInitialNode;
	private Button btnLoginTestUser;
	private Button btnTest;

	@Inject
	private IFileService fileService;

	@PostConstruct
	public void createComponents(final Composite parent, final INetworkConnectionService connectionService,
			final IUserService userService) {
		// MigLayout layout = new MigLayout("insets 1, wrap", "[]", "[][]");
		// parent.setLayout(layout);

		btnCreateInitialNode = new Button(parent, SWT.PUSH);
		btnCreateInitialNode.setText("Connect and Login");
		btnCreateInitialNode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				connectionService.createInitialNode();
			}
		});

		btnLoginTestUser = new Button(parent, SWT.PUSH);
		btnLoginTestUser.setText("Login Mr. X");
		btnLoginTestUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				userService.registerAndLoginUser("Mr. X", "password", "1234", Paths.get("/Users/Nendor/H2H/MrX"));
			}
		});

		btnTest = new Button(parent, SWT.PUSH);
		btnTest.setText("Update local file tree of user");
		btnTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fileService.updateFileTreeOfUser();
			}
		});
	}
}
