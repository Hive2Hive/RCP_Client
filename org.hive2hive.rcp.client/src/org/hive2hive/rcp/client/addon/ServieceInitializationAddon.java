package org.hive2hive.rcp.client.addon;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServieceInitializationAddon {

	private static final Logger logger = LoggerFactory.getLogger(ServieceInitializationAddon.class);

	@PostConstruct
	private void initializingServices(IModelService modelService, IFileService fileService, IEventBroker eventBroker) {
		logger.error("Going to init the UiModel - eventBroker={}", eventBroker);
		modelService.initModelService(eventBroker);
		fileService.initFileService(eventBroker);

	}
}
