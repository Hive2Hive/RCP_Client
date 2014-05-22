package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.events.ConnectionStatus;
import org.hive2hive.rcp.client.events.EventConstatns;

public class BottomBar {
	private Label lblConnection;
	private Label lblUser;
	private ImageViewerCached progressSymbol;
	private Label lblProgressMessage;

	@Inject
	private IBundleResourceLoader bundleResourceLoader;

	@PostConstruct
	public void createControlls(Composite parent, IBundleResourceLoader resourceLoader) {
		lblConnection = new Label(parent, SWT.NONE);
		lblConnection.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/Connection_disabled_32x32.png"));

		lblUser = new Label(parent, SWT.NONE);
		lblUser.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/User_32x32.png"));

		createProgressInformationControlls(parent, resourceLoader);
	}

	private void createProgressInformationControlls(Composite parent, IBundleResourceLoader resourceLoader) {
		final ImageData[] imageData = resourceLoader.loadImageData(this.getClass(), "images/loader.gif");
		progressSymbol = new ImageViewerCached(parent);
		progressSymbol.setImage(imageData[0]);
		progressSymbol.setImages(imageData, 0);
		progressSymbol.setVisible(false);

		lblProgressMessage = new Label(parent, SWT.NONE);
	}

	@Inject
	@Optional
	public void updateConnection(@UIEventTopic(EventConstatns.CONNECTION_STATUS) ConnectionStatus connectionStatus) {
		switch (connectionStatus) {
			case DISCONNECTED:
				lblConnection.setImage(bundleResourceLoader.loadImage(this.getClass(),
						"images/Connection_disabled_32x32.png"));
				break;
			case CONNECTED:
				lblConnection.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/Connection_32x32.png"));
				break;
		}
	}

	@Inject
	@Optional
	private void handleProgressInformation(@UIEventTopic(EventConstatns.PROGRESS_INFORMATION) String message) {
		if (message != null && !message.isEmpty()) {
			progressSymbol.setVisible(true);
			lblProgressMessage.setText(message);
		} else {
			progressSymbol.setVisible(false);
			lblProgressMessage.setText("");
		}
	}
}
