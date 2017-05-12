package org.liang.project.service.storage;

public class StorageFileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3804222295908961797L;
	
	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
