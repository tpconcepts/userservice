package com.library.userservice.dto;

public class NotificationDTO {

	String receiverEmail;

	String subject;

	String message;

	String noticationType;

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the noticationType
	 */
	public String getNoticationType() {
		return noticationType;
	}

	/**
	 * @param noticationType the noticationType to set
	 */
	public void setNoticationType(String noticationType) {
		this.noticationType = noticationType;
	}

}