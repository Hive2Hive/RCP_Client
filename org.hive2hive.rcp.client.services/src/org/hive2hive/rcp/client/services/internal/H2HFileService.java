package org.hive2hive.rcp.client.services.internal;

import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.exceptions.NoSessionException;
import org.hive2hive.core.processes.framework.interfaces.IResultProcessComponent;
import org.hive2hive.core.processes.implementations.files.list.FileTaste;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.ServicePayloadAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HFileService implements IFileService {
	private static Logger logger = LoggerFactory.getLogger(H2HFileService.class);

	private IFileManager fileManager;

	@Override
	public void test(IEventBroker eventBroker) {
		logger.debug("test method called.");
		eventBroker.send(IFileService.TEST, "Test");
	}

	@Override
	public void fetchUpdatedFileList(IEventBroker eventBroker) {
		IFileManager fileManager = getFileManager();
		try {
			IResultProcessComponent<List<FileTaste>> resultProcessComponent = fileManager.getFileList();
			resultProcessComponent.attachListener(new ProcessComponentPayloadListenerWrapper<List<FileTaste>>(
					new FileServiceListener<List<FileTaste>>(eventBroker, FILE_LIST_UPDATE), resultProcessComponent));
		} catch (NoSessionException e) {
			logger.error("Can't fetch current file list.", e);
		}
	}

	private IFileManager getFileManager() {
		if (fileManager == null) {
			INetworkConnectionService networkConnectionService = ServiceHelper.getService(INetworkConnectionService.class);
			logger.debug("NetworkConnectionService is: {}", networkConnectionService);
			fileManager = networkConnectionService.getCurrentNode().getFileManager();
		}
		return fileManager;
	}

	private class FileServiceListener<T> extends ServicePayloadAdapter<T> {
		private final Logger logger = LoggerFactory.getLogger(FileServiceListener.class);

		private final IEventBroker eventBroker;
		private final String event;

		public FileServiceListener(IEventBroker eventBroker, String event) {
			this.eventBroker = eventBroker;
			this.event = event;
		}

		@Override
		public void serviceFinished() {
			logger.debug("File service finished.");
		}

		@Override
		public void serviceSucceeded() {
			logger.debug("File service succeeded.");
			eventBroker.send(event, getPayload());
		}
	}

}
