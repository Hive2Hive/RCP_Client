package org.hive2hive.rcp.client.parts.filedetails;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import net.miginfocom.swt.MigLayout;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.model.filetree.FileTreeElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDetailPart {

	private static final Logger logger = LoggerFactory.getLogger(FileDetailPart.class);

	private Label lblFileName;
	private Label lblPath;
	private Label lblFileSize;

	private TableViewer tblSharedWith;
	private TableViewer tblFileVersions;

	private Image accessGrantedImage;
	private Image accessDeniedImage;

	@PostConstruct
	public void createControlls(Composite parent, IBundleResourceLoader resourceLoader) {

		accessGrantedImage = resourceLoader.loadImage(this.getClass(), "images/check/Check16x16.png");
		accessDeniedImage = resourceLoader.loadImage(this.getClass(), "images/cross/Cross16x16.png");

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

		createSharedWithTable(parent, resourceLoader);
		createFileVersionTable(parent);
	}

	@Inject
	private void handleSelectionChanged(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) FileTreeElement element) {
		if (element != null) {
			logger.debug("Selected element: {}", element);

			lblFileName.setText(element.getName());
			lblPath.setText(element.getPath().toString());

			updateAccessRights(element);
		}
	}

	private void updateAccessRights(FileTreeElement element) {
		tblSharedWith.setInput(element.getAccessRights());
	}

	private void createSharedWithTable(Composite parent, IBundleResourceLoader resourceLoader) {
		tblSharedWith = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		Table table = tblSharedWith.getTable();
		table.setLayoutData("height 80::");
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tblSharedWith.setContentProvider(ArrayContentProvider.getInstance());

		TableViewerColumn col = new TableViewerColumn(tblSharedWith, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("User-ID");
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((AccessRight) element).getUserId();
			}
		});

		col = new TableViewerColumn(tblSharedWith, SWT.CENTER);
		col.getColumn().setWidth(22);
		col.getColumn().setText("r");
		col.getColumn().setResizable(false);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return getImageForAccessRight(((AccessRight) element).isReadPermission());
			}

			@Override
			public String getText(Object element) {
				return null;
			}
		});

		col = new TableViewerColumn(tblSharedWith, SWT.CENTER);
		col.getColumn().setWidth(22);
		col.getColumn().setText("w");
		col.getColumn().setResizable(false);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return getImageForAccessRight(((AccessRight) element).isWritePermission());
			}

			@Override
			public String getText(Object element) {
				return null;
			}
		});
	}

	private void createFileVersionTable(Composite parent) {
		tblFileVersions = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		Table table = tblFileVersions.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// // TODO Nendor: create proper instances here
		// tblFileVersions.setContentProvider(new ShareContentProvider());
		// tblFileVersions.setLabelProvider(new ShareLabelProvider());
	}

	private Image getImageForAccessRight(boolean hasPermission) {
		if (hasPermission) {
			return accessGrantedImage;
		}
		return accessDeniedImage;
	}

}
