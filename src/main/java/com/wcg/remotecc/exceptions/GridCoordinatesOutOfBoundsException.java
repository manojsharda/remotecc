package com.wcg.remotecc.exceptions;

@SuppressWarnings("serial")
public class GridCoordinatesOutOfBoundsException extends RuntimeException {
	public GridCoordinatesOutOfBoundsException(final String message) {
		super(message);
	}
}
