package org.hive2hive.rcp.client.services.internal.process.file;

import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.exceptions.NoSessionException;
import org.hive2hive.core.processes.framework.exceptions.InvalidProcessStateException;
import org.hive2hive.core.processes.framework.exceptions.ProcessExecutionException;
import org.hive2hive.core.processes.framework.interfaces.IResultProcessComponent;
import org.hive2hive.core.processes.implementations.files.list.FileTaste;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.internal.process.ResultProcessWaiter;
import org.hive2hive.rcp.client.services.internal.process.ServiceProcessStep;

public class FetchFileTreeStep extends ServiceProcessStep {
	private final IFileManager fileManager;

	public FetchFileTreeStep(IFileManager fileManager, IEventBroker eventBroker) {
		super(IFileService.FILE_SERVICE_STATUS, eventBroker);
		this.fileManager = fileManager;
	}

	@Override
	protected void doExecute() throws InvalidProcessStateException, ProcessExecutionException {
		try {
			IResultProcessComponent<List<FileTaste>> resultProcessComponent = fileManager.getFileList();
			ResultProcessWaiter<List<FileTaste>> waiter = new ResultProcessWaiter<>();
			resultProcessComponent.attachListener(waiter);
			waiter.await();
			List<FileTaste> result = waiter.getResult();
			if (result != null) {
				publish(IFileService.FILE_LIST_UPDATE, result);
			}
		} catch (NoSessionException e) {
			e.printStackTrace();
		}

	}

}
