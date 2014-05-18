package org.hive2hive.rcp.client.parts;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class FileTreePart {

	private TreeViewer treeViewer;
	private Tree tree;

	@PostConstruct
	public void createControlls(final Composite parent) {
		tree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		treeViewer = new TreeViewer(tree);

		TreeColumn col = new TreeColumn(tree, SWT.LEFT);
		col.setAlignment(SWT.LEFT);
		col.setText("Files");
		col.setWidth(100);

		col = new TreeColumn(tree, SWT.LEFT);
		col.setAlignment(SWT.LEFT);
		col.setText("Infos");
		col.setWidth(100);
	}
}
