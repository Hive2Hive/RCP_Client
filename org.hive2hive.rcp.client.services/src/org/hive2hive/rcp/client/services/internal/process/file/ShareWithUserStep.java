package org.hive2hive.rcp.client.services.internal.process.file;

import java.io.File;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.hive2hive.core.api.interfaces.IFileManager;
import org.hive2hive.core.exceptions.IllegalFileLocation;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.exceptions.NoSessionException;
import org.hive2hive.core.model.PermissionType;
import org.hive2hive.processframework.RollbackReason;
import org.hive2hive.processframework.exceptions.InvalidProcessStateException;
import org.hive2hive.processframework.exceptions.ProcessExecutionException;
import org.hive2hive.processframework.interfaces.IProcessComponent;
import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.internal.process.ComponentCompletionWaiter;
import org.hive2hive.rcp.client.services.internal.process.ServiceProcessStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShareWithUserStep extends ServiceProcessStep {

	private static final Logger logger = LoggerFactory.getLogger(ShareWithUserStep.class);

	private final String userId;
	private final File file;
	private final AccessRight accessRight;

	private final IFileManager fileManager;

	public ShareWithUserStep(String userId, File file, AccessRight accessRight, IFileManager fileManager,
			IEventBroker eventBroker) {
		super(IFileService.FILE_SERVICE_STATUS, eventBroker);
		this.userId = userId;
		this.file = file;
		this.accessRight = accessRight;
		this.fileManager = fileManager;
	}

	@Override
	protected void doExecute() throws InvalidProcessStateException, ProcessExecutionException {
		PermissionType permission = PermissionType.READ;
		if (accessRight.isWritePermission()) {
			permission = PermissionType.WRITE;
		}
		try {
			logger.debug("Sharing file '{}' with user '{}' - AccessRight={}", file.getName(), userId, permission);
			IProcessComponent pc = fileManager.share(file, userId, permission);
			ComponentCompletionWaiter waiter = new ComponentCompletionWaiter();

			pc.attachListener(waiter);
			waiter.await();

			if (waiter.getRollBackReason() != null) {
				logger.debug("The sharing process step failed for the following reason: {}", waiter.getRollBackReason()
						.getHint());
				cancel(waiter.getRollBackReason());
			} else {
				logger.debug("Sharing successful.");
			}
		} catch (IllegalFileLocation | IllegalArgumentException e) {
			RollbackReason reason = new RollbackReason(e.getMessage(), e);
			cancel(reason);
			logger.error("Arguments not valide.", e);
		} catch (NoSessionException | NoPeerConnectionException e) {
			RollbackReason reason = new RollbackReason(e.getMessage(), e);
			cancel(reason);
			logger.error("Problems with the network - connection, peer, etc.", e);
		}
	}
}
