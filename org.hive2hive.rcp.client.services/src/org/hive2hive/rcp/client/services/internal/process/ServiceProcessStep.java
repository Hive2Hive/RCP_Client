package org.hive2hive.rcp.client.services.internal.process;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.widgets.Display;
import org.hive2hive.core.processes.framework.abstracts.ProcessStep;
import org.hive2hive.rcp.client.model.filetree.User;
import org.hive2hive.rcp.client.services.IUserService;

public abstract class ServiceProcessStep extends ProcessStep {

	private final String topicId;
	private final IEventBroker eventBroker;

	public ServiceProcessStep(String topicId, IEventBroker eventBroker) {
		this.topicId = topicId;
		this.eventBroker = eventBroker;
	}

	protected void publishProcessState(final IUserService.Status status) {
		publishProcessState(status, null);
	}

	protected void publishProcessState(final IUserService.Status status, final String message) {
		publishProcessInfo(topicId, new IUserService.StatusMessage(status, message));
	}

	protected void publish(String messageId, User messageObject) {
		eventBroker.post(messageId, messageObject);
	}

	private void publishProcessInfo(final String eventId, final Object eventObject) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				eventBroker.post(eventId, eventObject);
			}
		};
		executeAsync(r);
	}

	private void executeAsync(Runnable runnable) {
		Display.getDefault().asyncExec(runnable);
	}

}
