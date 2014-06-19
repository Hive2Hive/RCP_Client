package org.hive2hive.rcp.client.services.internal.process.file;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.util.EMap;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.exceptions.NoSessionException;
import org.hive2hive.core.model.IFileVersion;
import org.hive2hive.core.processes.framework.exceptions.InvalidProcessStateException;
import org.hive2hive.core.processes.framework.exceptions.ProcessExecutionException;
import org.hive2hive.core.processes.framework.interfaces.IResultProcessComponent;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
import org.hive2hive.rcp.client.model.filetree.TreeElement;
import org.hive2hive.rcp.client.model.filetree.Version;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.hive2hive.rcp.client.services.internal.process.ResultProcessWaiter;
import org.hive2hive.rcp.client.services.internal.process.ServiceProcessStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchFileVersionsStep extends ServiceProcessStep {

	private static final Logger logger = LoggerFactory.getLogger(FetchFileVersionsStep.class);
	private File file;
	private IFileManager fileManager;
	private IModelService modelService;

	public FetchFileVersionsStep(File file, IFileManager fileManager, IModelService modelService, IEventBroker eventBroker) {
		super(IFileService.FILE_SERVICE_STATUS, eventBroker);
		this.file = file;
		this.fileManager = fileManager;
		this.modelService = modelService;
	}

	@Override
	protected void doExecute() throws InvalidProcessStateException, ProcessExecutionException {
		logger.debug("Starting the fetching process for file versions of '{}'", file.getName());
		try {
			IResultProcessComponent<List<IFileVersion>> resultProcessComponent = fileManager.getFileVersions(file);
			ResultProcessWaiter<List<IFileVersion>> waiter = new ResultProcessWaiter<List<IFileVersion>>();
			resultProcessComponent.attachListener(waiter);
			waiter.await();
			List<IFileVersion> versions = waiter.getResult();
			EMap<Path, TreeElement> treeElements = modelService.getModel().getUser().getLocalTree().getElements();
			Path filePath = Paths.get(file.getPath());
			TreeElement treeElement = treeElements.get(filePath);
			addVersionsToElement(versions, treeElement);
			publish(IFileService.FETCHED_FILE_VERSIONS, versions);
		} catch (NoSessionException | NoPeerConnectionException e) {
			e.printStackTrace();
		}
	}

	private void addVersionsToElement(List<IFileVersion> versions, TreeElement treeElement) {
		treeElement.getVersions().clear();
		List<Version> elementVersions = treeElement.getVersions();
		for (IFileVersion fileVersion : versions) {
			Version version = FileTreeFactory.eINSTANCE.createVersion();
			version.setIndex(fileVersion.getIndex());
			version.setSize(fileVersion.getSize());
			version.setTimeStamp(fileVersion.getDate());
			elementVersions.add(version);

		}
		Collections.sort(elementVersions);
	}

}
