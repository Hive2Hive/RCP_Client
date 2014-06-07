package org.hive2hive.rcp.client.services.internal;

import java.io.File;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.processes.framework.RollbackReason;
import org.hive2hive.core.processes.framework.concretes.SequentialProcess;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.hive2hive.rcp.client.services.INetworkConnectionService;
import org.hive2hive.rcp.client.services.IService;
import org.hive2hive.rcp.client.services.internal.process.file.FetchFileTreeStep;
import org.hive2hive.rcp.client.services.internal.process.file.ShareWithUserStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2HFileService extends H2HService implements IFileService {

	private IFileManager getFileManager() {
		INetworkConnectionService networkConnectionService = getService(INetworkConnectionService.class);
		return networkConnectionService.getCurrentNode().getFileManager();
	}

	@Override
	public void updateFileTreeOfUser(IEventBroker eventBroker) {
		SequentialProcess process = new SequentialProcess();
		process.add(new FetchFileTreeStep(getFileManager(), getService(IModelService.class), eventBroker));
		runProcessAsynchronously(process);
	}

	@Override
	public void shareWithUser(String userId, File file, AccessRight accessRight, IEventBroker eventBroker) {
		SequentialProcess process = new SequentialProcess();
		process.add(new ShareWithUserStep(userId, file, accessRight, getFileManager(), eventBroker));
		process.add(new FetchFileTreeStep(getFileManager(), getService(IModelService.class), eventBroker));
		process.attachListener(new ProcessFailureListener(eventBroker));
		runProcessAsynchronously(process);
	}

	private class ProcessFailureListener implements IProcessComponentListener {

		private final Logger logger = LoggerFactory.getLogger(ProcessFailureListener.class);

		private final IEventBroker eventBroker;

		public ProcessFailureListener(IEventBroker eventBroker) {
			this.eventBroker = eventBroker;
		}

		@Override
		public void onSucceeded() {
			logger.error("Process successful - nothing to be done here");
		}

		@Override
		public void onFailed(RollbackReason reason) {
			logger.error("Proccess failed - handle me!  reason:{}", reason.getHint());
			eventBroker.post(IService.SERVICE_ERROR, reason.getHint());
		}

	}

}
