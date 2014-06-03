package org.hive2hive.rcp.client.services.internal;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.processes.framework.concretes.SequentialProcess;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.internal.process.file.FetchFileTreeStep;

public class H2HFileService extends H2HService implements IFileService {

	private IFileManager getFileManager() {
		INetworkConnectionService networkConnectionService = getService(INetworkConnectionService.class);
		return networkConnectionService.getCurrentNode().getFileManager();
	}

	@Override
	public void updateFileTreeOfUser(IEventBroker eventBroker) {
		SequentialProcess p = new SequentialProcess();
		p.add(new FetchFileTreeStep(getFileManager(), getService(IModelService.class), eventBroker));
		runProcessAsynchronously(p);
	}

}
