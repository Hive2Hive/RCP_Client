package org.hive2hive.rcp.client.services.internal;

import org.eclipse.swt.widgets.Display;
import org.hive2hive.core.processes.framework.RollbackReason;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.hive2hive.core.processes.framework.interfaces.IResultProcessComponent;
import org.hive2hive.rcp.client.services.IServicePayloadListener;

public class ProcessComponentPayloadListenerWrapper<T> implements IProcessComponentListener {
	private final IServicePayloadListener<T> listener;
	private final IResultProcessComponent<T> resultProcessComponent;

	public ProcessComponentPayloadListenerWrapper(IServicePayloadListener<T> listener,
			IResultProcessComponent<T> resultProcessComponent) {
		this.listener = listener;
		this.resultProcessComponent = resultProcessComponent;
	}

	@Override
	public void onSucceeded() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				listener.setPayload(resultProcessComponent.getResult());
				listener.serviceFinished();
				listener.serviceSucceeded();
			}
		};
		executeAsync(runnable);
	}

	@Override
	public void onFailed(RollbackReason reason) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				listener.serviceFinished();
				listener.serviceFailed();
			}
		};
		executeAsync(runnable);
	}

	private void executeAsync(Runnable runnable) {
		Display.getDefault().asyncExec(runnable);
	}
}