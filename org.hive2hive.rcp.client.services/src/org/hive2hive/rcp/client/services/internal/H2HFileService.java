package org.hive2hive.rcp.client.services.internal;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.processes.framework.concretes.SequentialProcess;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.internal.process.file.FetchFileTreeStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HFileService extends H2HService implements IFileService {
	private static Logger logger = LoggerFactory.getLogger(H2HFileService.class);

	private IFileManager fileManager;

	private IFileManager getFileManager() {
		if (fileManager == null) {
			INetworkConnectionService networkConnectionService = getService(INetworkConnectionService.class);
			logger.debug("NetworkConnectionService is: {}", networkConnectionService);
			fileManager = networkConnectionService.getCurrentNode().getFileManager();
		}
		return fileManager;
	}

	@Override
	public void updateFileTreeOfUser(IEventBroker eventBroker) {
		SequentialProcess p = new SequentialProcess();
		p.add(new FetchFileTreeStep(getFileManager(), eventBroker));
		runProcessAsynchronously(p);
	}

}
