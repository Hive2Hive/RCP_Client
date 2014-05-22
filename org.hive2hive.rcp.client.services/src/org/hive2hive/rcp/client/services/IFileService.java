package org.hive2hive.rcp.client.services;

import org.eclipse.e4.core.services.events.IEventBroker;

public interface IFileService {
	public static final String TEST = "TEST";
	public static final String FILE_LIST_UPDATE = "FILE_LIST_UPDATE";

	/**
	 * @param eventBroker
	 * @Deprecated For testing only - will be removed soon.
	 *             TODO Nendor: Remove this
	 */
	void test(IEventBroker eventBroker);

	void fetchUpdatedFileList(IEventBroker eventBroker);
}
