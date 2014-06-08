package org.hive2hive.rcp.client.services;

public interface IService {
	public static final String SERVICE_FAILURE = "SERVICE_ERROR";

	public class StatusMessage<T> {
		private final T status;
		private final String message;

		public StatusMessage(T status, String message) {
			this.status = status;
			this.message = message;
		}

		public T getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}
	}
}
