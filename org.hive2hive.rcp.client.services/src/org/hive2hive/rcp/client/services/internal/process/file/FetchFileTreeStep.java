package org.hive2hive.rcp.client.services.internal.process.file;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.exceptions.NoSessionException;
import org.hive2hive.core.model.PermissionType;
import org.hive2hive.core.model.UserPermission;
import org.hive2hive.core.processes.framework.exceptions.InvalidProcessStateException;
import org.hive2hive.core.processes.framework.exceptions.ProcessExecutionException;
import org.hive2hive.core.processes.framework.interfaces.IResultProcessComponent;
import org.hive2hive.core.processes.implementations.files.list.FileTaste;
import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.model.filetree.Directory;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
import org.hive2hive.rcp.client.model.filetree.Tree;
import org.hive2hive.rcp.client.model.filetree.TreeElement;
import org.hive2hive.rcp.client.model.filetree.User;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.hive2hive.rcp.client.services.internal.process.ResultProcessWaiter;
import org.hive2hive.rcp.client.services.internal.process.ServiceProcessStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchFileTreeStep extends ServiceProcessStep {
	private static final Logger logger = LoggerFactory.getLogger(FetchFileTreeStep.class);

	private final IFileManager fileManager;
	private final IModelService modelService;

	public FetchFileTreeStep(IFileManager fileManager, IModelService modelService, IEventBroker eventBroker) {
		super(IFileService.FILE_SERVICE_STATUS, eventBroker);
		this.fileManager = fileManager;
		this.modelService = modelService;
	}

	@Override
	protected void doExecute() throws InvalidProcessStateException, ProcessExecutionException {
		try {
			logger.debug("Start fetching file tree.");
			IResultProcessComponent<List<FileTaste>> resultProcessComponent = fileManager.getFileList();
			ResultProcessWaiter<List<FileTaste>> waiter = new ResultProcessWaiter<>();
			resultProcessComponent.attachListener(waiter);
			waiter.await();
			List<FileTaste> result = waiter.getResult();
			if (result != null) {
				createFileTree(result);
				publish(IFileService.FILE_SERVICE_STATUS, IFileService.Status.FILE_LIST_UPDATE);
				logger.debug("Fetching file tree successful.");
			}
		} catch (NoSessionException e) {
			e.printStackTrace();
		}

	}

	private void createFileTree(List<FileTaste> fileList) {

		User user = modelService.getUser();

		FileTreeFactory factory = FileTreeFactory.eINSTANCE;
		Tree tree = factory.createTree();
		tree.setName(String.format("file root of '%s'", user.getUserId()));
		tree.setPath(user.getRootDir());

		Directory rootDir = factory.createDirectory();
		rootDir.setName(user.getRootDir().toString());
		rootDir.setPath(user.getRootDir());
		tree.getElements().put(rootDir.getPath(), rootDir);
		logger.debug("Hash of root dir path = {}", rootDir.getPath().hashCode());
		tree.getChildren().add(rootDir);

		for (FileTaste fileTaste : fileList) {
			TreeElement treeElement;
			if (fileTaste.getFile().isDirectory()) {
				treeElement = FileTreeFactory.eINSTANCE.createDirectory();
			} else {
				treeElement = FileTreeFactory.eINSTANCE.createFile();
			}
			addFileTreeElement(tree, treeElement, fileTaste);
		}

		user.setFileTree(tree);
	}

	private void addFileTreeElement(Tree tree, TreeElement treeElement, FileTaste fileTaste) {
		treeElement.setName(fileTaste.getName());
		treeElement.setPath(fileTaste.getFile().toPath());
		treeElement.setFile(fileTaste.getFile());
		tree.getElements().put(treeElement.getPath(), treeElement);
		addAccessRights(treeElement, fileTaste);
		addToParent(tree, treeElement);
	}

	private void addAccessRights(TreeElement treeElement, FileTaste fileTaste) {
		for (UserPermission permission : fileTaste.getUserPermissions()) {
			AccessRight accessRight = FileTreeFactory.eINSTANCE.createAccessRight();
			accessRight.setUserId(permission.getUserId());
			accessRight.setReadPermission(true);
			accessRight.setWritePermission(PermissionType.WRITE == permission.getPermission());
			treeElement.getAccessRights().add(accessRight);
		}
	}

	void addToParent(Tree tree, TreeElement treeElement) {
		Path parentPath = treeElement.getPath().getParent();
		Directory parent = (Directory) tree.getElements().get(parentPath);
		parent.getChildren().add(treeElement);
	}
}
