package org.hive2hive.rcp.client.services.internal;

import org.eclipse.swt.widgets.Display;
import org.hive2hive.core.processes.framework.RollbackReason;
import org.hive2hive.core.processes.framework.interfaces.IProcessComponentListener;
import org.hive2hive.rcp.client.services.IServiceListener;

public class ProcessComponentListenerWrapper implements IProcessComponentListener {
	private final IServiceListener listener;

	public ProcessComponentListenerWrapper(IServiceListener listener) {
		this.listener = listener;
	}

	@Override
	public void onSucceeded() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
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