package org.hive2hive.rcp.client.services.internal.process;

import java.util.concurrent.CountDownLatch;

import org.hive2hive.core.processes.framework.RollbackReason;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentCompletionWaiter implements IProcessComponentListener {
	private final Logger logger = LoggerFactory.getLogger(ComponentCompletionWaiter.class);

	private final CountDownLatch latch = new CountDownLatch(1);
	private RollbackReason rollBackReason;

	@Override
	public void onSucceeded() {
		latch.countDown();
	}

	@Override
	public void onFailed(RollbackReason reason) {
		rollBackReason = reason;
		latch.countDown();
	}

	public void await() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			logger.error("Wait for the process component to finish was interrupted.", e);
		}
	}

	public RollbackReason getRollBackReason() {
		return rollBackReason;
	}
}