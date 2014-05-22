package org.hive2hive.rcp.client.model.filetree.util;

import java.nio.file.Paths;

import org.hive2hive.rcp.client.model.filetree.Directory;
import org.hive2hive.rcp.client.model.filetree.File;
import org.hive2hive.rcp.client.model.filetree.FileTree;
import org.hive2hive.rcp.client.model.filetree.FileTreeElement;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;

public final class FileTreeModelUtile {

	private FileTreeModelUtile() {
	}

	public static FileTreeElement createDummyModel() {
		FileTreeFactory factory = FileTreeFactory.eINSTANCE;
		FileTree tree = factory.createFileTree();
		tree.setName("Tree name");
		tree.setPath(Paths.get("/root"));

		Directory rootDir = factory.createDirectory();
		rootDir.setName("/root");
		rootDir.setPath(Paths.get("/root"));

		Directory dir1 = factory.createDirectory();
		dir1.setName("dir1");
		dir1.setPath(Paths.get("/root/dir1"));
		rootDir.getChildren().add(dir1);

		File fileA = factory.createFile();
		fileA.setName("FileA");
		fileA.setPath(Paths.get("/root/dir1/FileA"));
		dir1.getChildren().add(fileA);

		Directory subDir1 = factory.createDirectory();
		subDir1.setName("SubDir1");
		subDir1.setPath(Paths.get("/root/dir1/SubDir1"));
		dir1.getChildren().add(subDir1);

		File subFileA = factory.createFile();
		subFileA.setName("SubFileA");
		subFileA.setPath(Paths.get("/root/dir1/SubDir1/SubFileA"));
		subDir1.getChildren().add(subFileA);

		tree.getChildren().add(rootDir);
		return tree;

	}
}
