package org.hive2hive.rcp.client.services.internal;

import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
import org.hive2hive.rcp.client.model.filetree.User;
import org.hive2hive.rcp.client.services.IModelService;

public class H2HModelService implements IModelService {

	private User user = FileTreeFactory.eINSTANCE.createUser();

	@Override
	public User getUser() {
		return user;
	}

}
