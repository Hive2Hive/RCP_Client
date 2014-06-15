package org.hive2hive.rcp.client.parts.filetree;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.hive2hive.rcp.client.model.filetree.Container;
import org.hive2hive.rcp.client.model.filetree.TreeElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTreeContentProvider implements ITreeContentProvider {

	private static final Logger logger = LoggerFactory.getLogger(FileTreeContentProvider.class);

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		logger.debug("input changed.");
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Container) {
			Container container = (Container) parentElement;
			return container.getChildren().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		TreeElement treeElement = (TreeElement) element;
		return treeElement.getParent();
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Container) {
			Container container = (Container) element;
			return !container.getChildren().isEmpty();
		}
		return false;
	}

}
