package org.hive2hive.rcp.client.services.internal.process.file;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.exceptions.NoSessionException;
import org.hive2hive.core.model.PermissionType;
import org.hive2hive.core.model.UserPermission;
import org.hive2hive.core.processes.files.list.FileTaste;
import org.hive2hive.processframework.exceptions.InvalidProcessStateException;
import org.hive2hive.processframework.exceptions.ProcessExecutionException;
import org.hive2hive.processframework.interfaces.IResultProcessComponent;
import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.model.filetree.Directory;
import org.hive2hive.rcp.client.model.filetree.FileTree;
import org.hive2hive.rcp.client.model.filetree.FileTreeElement;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
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
		FileTree tree = factory.createFileTree();
		tree.setName(String.format("file root of '%s'", user.getUserId()));
		tree.setPath(user.getRootDir());

		Directory rootDir = factory.createDirectory();
		rootDir.setName(user.getRootDir().toString());
		rootDir.setPath(user.getRootDir());
		tree.getElements().put(rootDir.getPath(), rootDir);
		logger.debug("Hash of root dir path = {}", rootDir.getPath().hashCode());
		tree.getChildren().add(rootDir);

		for (FileTaste fileTaste : fileList) {
			FileTreeElement element;
			if (fileTaste.getFile().isDirectory()) {
				element = FileTreeFactory.eINSTANCE.createDirectory();
			} else {
				element = FileTreeFactory.eINSTANCE.createH2HFile();
			}
			addFileTreeElement(tree, element, fileTaste);
		}

		user.setFileTree(tree);
	}

	private void addFileTreeElement(FileTree tree, FileTreeElement element, FileTaste fileTaste) {
		element.setName(fileTaste.getName());
		element.setPath(fileTaste.getFile().toPath());
		element.setFile(fileTaste.getFile());
		tree.getElements().put(element.getPath(), element);
		addAccessRights(element, fileTaste);
		addToParent(tree, element);
	}

	private void addAccessRights(FileTreeElement element, FileTaste fileTaste) {
		for (UserPermission permission : fileTaste.getUserPermissions()) {
			AccessRight accessRight = FileTreeFactory.eINSTANCE.createAccessRight();
			accessRight.setUserId(permission.getUserId());
			accessRight.setReadPermission(true);
			accessRight.setWritePermission(PermissionType.WRITE == permission.getPermission());
			element.getAccessRights().add(accessRight);
		}
	}

	void addToParent(FileTree tree, FileTreeElement element) {
		Path parentPath = element.getPath().getParent();
		Directory parent = (Directory) tree.getElements().get(parentPath);
		parent.getChildren().add(element);
	}
}
