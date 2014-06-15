package org.hive2hive.rcp.client.services.internal;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
import org.hive2hive.rcp.client.model.filetree.User;
import org.hive2hive.rcp.client.services.IModelService;

public class H2HModelService implements IModelService {

	private User user = FileTreeFactory.eINSTANCE.createUser();
	private IEventBroker eventBroker;

	@Override
	public void initModelService(IEventBroker eventBroker) {
		this.eventBroker = eventBroker;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void test() {
		eventBroker.post("IModelService/test/message", "Hello world from initilaized UiModel!");
	}

}
