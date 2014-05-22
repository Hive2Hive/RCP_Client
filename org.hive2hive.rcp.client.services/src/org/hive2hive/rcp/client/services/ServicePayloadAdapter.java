package org.hive2hive.rcp.client.services;

public class ServicePayloadAdapter<T> extends ServiceAdapter implements IServicePayloadListener<T> {

	private T payload;

	@Override
	public void serviceFinished() {
	}

	@Override
	public void serviceFailed() {
	}

	@Override
	public void serviceSucceeded() {
	}

	@Override
	public T getPayload() {
		return payload;
	}

	@Override
	public void setPayload(T payload) {
		this.payload = payload;
	}

}
