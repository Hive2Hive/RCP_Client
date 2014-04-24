package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;

public class TopBar {

	@PostConstruct
	public void createControls(Composite parent, IBundleResourceLoader bundleResourceLoader) {
		Label topBarLabel = new Label(parent, SWT.NONE);
		topBarLabel.setImage(bundleResourceLoader.loadImage(this.getClass(), "images/Logo_80x80.png"));
		topBarLabel = new Label(parent, SWT.NONE);
		Font font = new Font(topBarLabel.getDisplay(), new FontData("Arial", 30, SWT.BOLD));
		topBarLabel.setFont(font);
		topBarLabel.setText("HIVE2HIVE");
		Color backgroundColor = new Color(Display.getCurrent(), 91, 108, 141);
		Color foregroundColor = new Color(Display.getCurrent(), 255, 255, 255);
		topBarLabel.setBackground(backgroundColor);
		topBarLabel.setForeground(foregroundColor);
		parent.setBackground(backgroundColor);

	}
}
