package com.amzure.bookservice.handlers;

public class ResourceNotAvailableException extends RuntimeException {
	public ResourceNotAvailableException(String msg)
	{
		super(msg);
	}

}
