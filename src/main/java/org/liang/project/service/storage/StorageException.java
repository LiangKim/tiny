package org.liang.project.service.storage;

public class StorageException extends RuntimeException {
	private static final long serialVersionUID = 7039012133595579038L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
