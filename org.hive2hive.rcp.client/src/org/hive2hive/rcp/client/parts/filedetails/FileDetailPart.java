package org.hive2hive.rcp.client.parts.filedetails;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import net.miginfocom.swt.MigLayout;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.hive2hive.rcp.client.model.filetree.FileTreeElement;
import org.hive2hive.rcp.client.parts.filedetails.share.ShareContentProvider;
import org.hive2hive.rcp.client.parts.filedetails.share.ShareLabelProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDetailPart {

	private static final Logger logger = LoggerFactory.getLogger(FileDetailPart.class);

	private Label lblFileName;
	private Label lblPath;
	private Label lblFileSize;

	private TableViewer tblSharedWith;
	private TableViewer tblFileVersions;

	@PostConstruct
	public void createControlls(Composite parent) {
		MigLayout layout = new MigLayout("wrap", "[][]", "[][][]");
		parent.setLayout(layout);

		Label label = new Label(parent, SWT.NONE);
		label.setText("Name:");
		lblFileName = new Label(parent, SWT.NONE);
		lblFileName.setText("ExampleFile.txt");

		label = new Label(parent, SWT.NONE);
		label.setText("Path:");
		lblPath = new Label(parent, SWT.NONE);
		lblPath.setText("/abc/lll");

		label = new Label(parent, SWT.NONE);
		label.setText("Size:");
		lblFileSize = new Label(parent, SWT.NONE);
		lblFileSize.setText("63kb");

		createSharedWithTable(parent);
		createFileVersionTable(parent);
	}

	@Inject
	private void handleSelectionChanged(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) FileTreeElement element) {
		logger.debug("Selected element: {}", element);
	}

	private void createSharedWithTable(Composite parent) {
		tblSharedWith = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		Table table = tblSharedWith.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tblSharedWith.setContentProvider(new ShareContentProvider());
		tblSharedWith.setLabelProvider(new ShareLabelProvider());
	}

	private void createFileVersionTable(Composite parent) {
		tblFileVersions = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		Table table = tblFileVersions.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tblFileVersions.setContentProvider(new ShareContentProvider());
		tblFileVersions.setLabelProvider(new ShareLabelProvider());
	}

}
