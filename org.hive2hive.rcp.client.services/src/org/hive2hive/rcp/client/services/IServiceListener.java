package org.hive2hive.rcp.client.services;

public interface IServiceListener {
	public void serviceFinished();

	public void serviceFailed();

	public void serviceSucceeded();
}
