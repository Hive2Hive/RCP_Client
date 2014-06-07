package org.hive2hive.rcp.client.parts.filetree;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.hive2hive.rcp.client.model.filetree.Directory;
import org.hive2hive.rcp.client.model.filetree.FileTreeElement;
import org.hive2hive.rcp.client.model.filetree.H2HFile;

public class FileTreeLabelProvider implements ITableLabelProvider {

	private final Image folderImage;

	public FileTreeLabelProvider(Image folderImage) {
		this.folderImage = folderImage;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == 0) {
			if (element instanceof H2HFile) {
				H2HFile file = (H2HFile) element;
				String[] nameParts = file.getName().split("\\.");
				String fileExtension = "." + nameParts[nameParts.length - 1];
				Program program = Program.findProgram(fileExtension);
				if (program != null) {
					ImageData id = program.getImageData();
					return new Image(Display.getCurrent(), id);
				}
			}
			if (element instanceof Directory) {
				return folderImage;
			}
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		FileTreeElement treeElement = (FileTreeElement) element;
		switch (columnIndex) {
			case 0:
				return treeElement.getName();
			case 1:
				return treeElement.getPath().toString();
		}
		return null;
	}

}
