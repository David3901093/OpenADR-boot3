package com.avob.openadr.security.exception;

import java.io.IOException;

public class OadrSecurityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2034629918774732456L;

	public OadrSecurityException(String message) {
		super(message);
	}

	public OadrSecurityException(Exception e) {
		super(e);
	}


}
