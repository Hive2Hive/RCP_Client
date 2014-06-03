package org.hive2hive.rcp.client.services.internal.process;

import java.util.concurrent.CountDownLatch;

import org.hive2hive.core.processes.framework.interfaces.IProcessResultListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultProcessWaiter<T> implements IProcessResultListener<T> {

	private final Logger logger = LoggerFactory.getLogger(ResultProcessWaiter.class);

	private final CountDownLatch latch = new CountDownLatch(1);

	private T result = null;

	@Override
	public void onResultReady(T result) {
		latch.countDown();
		this.result = result;
	}

	public T getResult() {
		return result;
	}

	public void await() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			logger.error("Wait for the process component to finish was interrupted.", e);
		}
	}

}
