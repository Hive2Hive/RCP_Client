package org.hive2hive.rcp.client.services;

public class ServiceFailureMessage {
	private final String title;
	private final String message;
	private final String details;

	public ServiceFailureMessage(String title, String message, String details) {
		this.title = title;
		this.message = message;
		this.details = details;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}