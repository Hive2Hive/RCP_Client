package org.hive2hive.rcp.client.model.filetree.util;

import java.nio.file.Paths;

import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.model.filetree.Directory;
import org.hive2hive.rcp.client.model.filetree.FileTree;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
import org.hive2hive.rcp.client.model.filetree.H2HFile;

public final class FileTreeModelUtile {

	private FileTreeModelUtile() {
	}

	public static FileTree createDummyModel() {
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

		H2HFile fileA = factory.createH2HFile();
		fileA.setName("FileA.txt");
		fileA.setPath(Paths.get("/root/dir1/FileA"));
		AccessRight accessRight = factory.createAccessRight();
		accessRight.setUserId("Mr. X");
		accessRight.setReadPermission(true);
		accessRight.setWritePermission(true);
		fileA.getAccessRights().add(accessRight);

		accessRight = factory.createAccessRight();
		accessRight.setUserId("Scotland Yard");
		accessRight.setReadPermission(true);
		accessRight.setWritePermission(false);
		fileA.getAccessRights().add(accessRight);

		dir1.getChildren().add(fileA);

		Directory subDir1 = factory.createDirectory();
		subDir1.setName("SubDir1");
		subDir1.setPath(Paths.get("/root/dir1/SubDir1"));
		dir1.getChildren().add(subDir1);

		H2HFile subFileA = factory.createH2HFile();
		subFileA.setName("SubFileA.png");
		subFileA.setPath(Paths.get("/root/dir1/SubDir1/SubFileA"));
		subDir1.getChildren().add(subFileA);

		tree.getChildren().add(rootDir);
		return tree;

	}
}
