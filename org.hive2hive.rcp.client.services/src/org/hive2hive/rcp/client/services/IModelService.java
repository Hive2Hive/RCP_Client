package org.hive2hive.rcp.client.services;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.rcp.client.model.filetree.User;

public interface IModelService extends IService {

	public void initModelService(IEventBroker eventBroker);

	public User getUser();

	public void test();

}
