package org.hive2hive.rcp.client.services.internal;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.rcp.client.model.uimodel.UiModel;
import org.hive2hive.rcp.client.model.uimodel.UiModelFactory;
import org.hive2hive.rcp.client.services.IModelService;

public class H2HModelService implements IModelService {

	private UiModel model = UiModelFactory.eINSTANCE.createUiModel();
	private IEventBroker eventBroker;

	@Override
	public void initModelService(IEventBroker eventBroker) {
		this.eventBroker = eventBroker;
		model.setUser(UiModelFactory.eINSTANCE.createUser());
	}

	@Override
	public void test() {
		eventBroker.post("IModelService/test/message", "Hello world from initilaized UiModel!");
	}

	@Override
	public UiModel getModel() {
		return model;
	}

}
