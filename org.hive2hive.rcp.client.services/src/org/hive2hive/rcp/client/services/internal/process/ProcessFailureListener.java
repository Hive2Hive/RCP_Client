package org.hive2hive.rcp.client.services.internal.process;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.processes.framework.RollbackReason;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.hive2hive.rcp.client.services.IService;
import org.hive2hive.rcp.client.services.ServiceFailureMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessFailureListener implements IProcessComponentListener {

	private final Logger logger = LoggerFactory.getLogger(ProcessFailureListener.class);

	private final String title;
	private final String message;
	private final IEventBroker eventBroker;

	public ProcessFailureListener(String title, String message, IEventBroker eventBroker) {
		this.title = title;
		this.message = message;
		this.eventBroker = eventBroker;
	}

	@Override
	public void onSucceeded() {
		logger.error("Process successful - nothing to be done here");
	}

	@Override
	public void onFailed(RollbackReason reason) {
		logger.error("Proccess failed - reason:{}", reason.getHint());
		ServiceFailureMessage failureMessage = new ServiceFailureMessage(title, message, reason.getHint());
		eventBroker.post(IService.SERVICE_FAILURE, failureMessage);
	}

}