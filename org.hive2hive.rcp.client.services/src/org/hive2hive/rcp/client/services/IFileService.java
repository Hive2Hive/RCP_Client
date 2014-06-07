package org.hive2hive.rcp.client.services;

import java.io.File;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.rcp.client.model.filetree.AccessRight;

public interface IFileService {
	public static final String FILE_SERVICE_STATUS = "FILE_SERVICE_STATUS";

	public enum Status {
		FILE_LIST_UPDATE,
		ADDED_USER_ACCESS_RIGHT
	}

	void updateFileTreeOfUser(IEventBroker eventBroker);

	void shareWithUser(String userId, File file, AccessRight accessRight, IEventBroker eventBroker);

}
