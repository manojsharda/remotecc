package com.wcg.remotecc.exceptions;

@SuppressWarnings("serial")
public class CommandNotKnownException extends RuntimeException {

	public CommandNotKnownException(final String message) {
		super(message);
	}
}
