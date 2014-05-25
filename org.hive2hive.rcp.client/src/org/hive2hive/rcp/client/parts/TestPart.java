package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPart {

	private static final Logger logger = LoggerFactory.getLogger(TestPart.class);

	@Inject
	private IFileService fileService;

	@Inject
	private IEventBroker eventBroker;

	@Inject
	private IUserService userService;

	@PostConstruct
	public void createControls(final Composite parent, IBundleResourceLoader bundleResourceLoader, EMenuService menuService) {
		logger.debug("Hello World from H2H - Chat");
		logger.debug(this.getClass().getSimpleName() + " @PostConstruct method called.");

		Label label = new Label(parent, SWT.NONE);
		label.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/Logo_200x200.png"));

		menuService.registerContextMenu(label, "org.hive2hive.rcp.client.popupmenu.test");

		Button b = new Button(parent, SWT.PUSH);
		b.setText("Test");
		b.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// fileService.test(eventBroker);
				// fileService.fetchUpdatedFileList(eventBroker);
				userService.test(eventBroker);
			}
		});
		// logger.debug("extensions:");
		// for (String s : Program.getExtensions()) {
		// logger.debug(s);
		// }

		ImageData id = Program.findProgram(".png").getImageData();
		Image i = new Image(Display.getCurrent(), id);
		b.setImage(i);
	}

	@Focus
	private void setFocus() {
		logger.debug(this.getClass().getSimpleName() + " @Focus method called");
	}

	@Inject
	@Optional
	private void receiveTestMessage(@UIEventTopic(IFileService.TEST) String message) {
		logger.debug("Test message '{}' received from service - event broker is working.", message);
	}

	@Inject
	@Optional
	private void receiveTestMessageFromUserService(@UIEventTopic(IUserService.IUSERSERVICE_TEST) String message) {
		logger.debug("Got the following message: '{}'", message);
	}

}
