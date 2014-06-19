package org.hive2hive.rcp.client.services.internal.process;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.processes.framework.abstracts.ProcessStep;
import org.hive2hive.rcp.client.services.IService.StatusMessage;
import org.hive2hive.rcp.client.services.IUserService;

public abstract class ServiceProcessStep extends ProcessStep {

	private final String topicId;
	private final IEventBroker eventBroker;

	public ServiceProcessStep(String topicId, IEventBroker eventBroker) {
		this.topicId = topicId;
		this.eventBroker = eventBroker;
	}

	/**
	 * @Deprecated Use
	 *             {@link #publishProcessState(org.hive2hive.rcp.client.services.IUserService.Status, String)}
	 *             instead.
	 */
	@Deprecated
	protected void publishProcessState(final IUserService.Status status) {
		publishProcessState(status, null);
	}

	protected void publishProcessState(final IUserService.Status status, final String message) {
		publish(topicId, new StatusMessage<IUserService.Status>(status, message));
	}

	protected void publish(String messageId, Object messageObject) {
		eventBroker.post(messageId, messageObject);
	}

}
