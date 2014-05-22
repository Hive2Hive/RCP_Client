package org.hive2hive.rcp.client.services;

public interface IServicePayloadListener<T> extends IServiceListener {

	public T getPayload();

	public void setPayload(T payload);

}
