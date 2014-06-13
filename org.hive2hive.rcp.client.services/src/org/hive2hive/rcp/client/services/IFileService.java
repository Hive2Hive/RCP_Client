package org.hive2hive.rcp.client.services;

import java.io.File;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.rcp.client.model.filetree.AccessRight;

public interface IFileService extends IService {
	public static final String FILE_SERVICE_STATUS = "FILE_SERVICE_STATUS";
	// TODO switch this to status
	public static final String FETCHED_FILE_VERSIONS = "FETCHED_FILE_VERSIONS";

	public enum Status {
		FILE_LIST_UPDATE,
		ADDED_USER_ACCESS_RIGHT
	}

	void updateFileTreeOfUser(IEventBroker eventBroker);

	void shareWithUser(String userId, File file, AccessRight accessRight, IEventBroker eventBroker);

	void getFileVersions(File file, IEventBroker eventBroker);

}
