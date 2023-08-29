/**
 * 
 */
package com.springboot.exception;

/**
 * @author Junaid.khan
 *
 */

public class DuplicatesStudentRecordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public DuplicatesStudentRecordException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
