package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.model.todo.ITodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatPart {

	private static final Logger logger = LoggerFactory.getLogger(ChatPart.class);

	@PostConstruct
	public void createControls(final Composite parent, ITodoService todoService,
			IBundleResourceLoader bundleResourceLoader) {
		logger.debug("Hello World from H2H - Chat");
		logger.debug(this.getClass().getSimpleName() + " @PostConstruct method called.");

		logger.debug("Number of Todo objects = " + todoService.getTodos().size());

		Label label = new Label(parent, SWT.NONE);
		label.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/Logo_200x200.png"));
	}

	@Focus
	private void setFocus() {
		logger.debug(this.getClass().getSimpleName() + " @Focus method called");
	}

}
