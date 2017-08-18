package com.usman.liferay.message.model;

public class Message {

	private String name = "";
	private String message = "";

	public Message(){}
	
	public Message(String name, String message) {

		//setName(name);
		//setMessage(message);
		this.name=name;
		this.message=message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + ", message=" + message + "]";
	}

}
