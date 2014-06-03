package org.hive2hive.rcp.client.services;

import org.eclipse.e4.core.services.events.IEventBroker;

public interface IFileService {
	public static final String FILE_LIST_UPDATE = "FILE_LIST_UPDATE";
	public static final String FILE_SERVICE_STATUS = "FILE_SERVICE_STATUS";

	void updateFileTreeOfUser(IEventBroker eventBroker);

}
