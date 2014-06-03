package org.hive2hive.rcp.client.parts;

import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAdminPart {

	private static final Logger logger = LoggerFactory.getLogger(TestAdminPart.class);

	private Button btnCreateInitialNode;
	private Button btnLoginTestUser;
	private Button btnTest;

	@Inject
	private IEventBroker eventBroker;

	@Inject
	private IModelService modelService;

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
				connectionService.createInitialNode(eventBroker);
			}
		});

		btnLoginTestUser = new Button(parent, SWT.PUSH);
		btnLoginTestUser.setText("Login Mr. X");
		btnLoginTestUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				userService.registerAndLoginUser("Mr. X", "password", "1234", Paths.get("/Users/Nendor/H2H/MrX"),
						eventBroker);
			}
		});

		btnTest = new Button(parent, SWT.PUSH);
		btnTest.setText("Test");
		btnTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				logger.debug("user model = {}", modelService.getUser());
				fileService.updateFileTreeOfUser(eventBroker);
			}
		});
	}
}
