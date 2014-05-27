package org.hive2hive.rcp.client.services.internal.process;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.widgets.Display;
import org.hive2hive.core.processes.framework.abstracts.ProcessStep;
import org.hive2hive.rcp.client.services.IUserService;
import org.hive2hive.rcp.client.services.ServiceConstants;

public abstract class ServiceProcessStep extends ProcessStep {

	private final String topicId;
	private final IEventBroker eventBroker;

	public ServiceProcessStep(String topicId, IEventBroker eventBroker) {
		this.topicId = topicId;
		this.eventBroker = eventBroker;
	}

	@Deprecated
	protected void publishProcessFinished() {
		publishProcessInfo(ServiceConstants.SERVICE_FINISHED, ServiceConstants.SERVICE_FINISHED);
	}

	@Deprecated
	protected void publishProcessState(final String eventMessage) {
		publishProcessInfo(topicId, eventMessage);
	}

	protected void publishProcessState(final IUserService.Status status) {
		publishProcessInfo(topicId, status);
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
