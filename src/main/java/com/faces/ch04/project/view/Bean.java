package com.faces.ch04.project.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Bean {
	private String text;
	private String password;
	private String message;
	private String hidden;
	
	
	
	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getHidden() {
		return hidden;
	}



	public void setHidden(String hidden) {
		this.hidden = hidden;
	}



	public void submit() {
		System.out.println("The Form has been submitted");
		System.out.println("text: " + text);
		System.out.println("password: " + password);
		System.out.println("message: " + message);
		System.out.println("hidden: " + hidden);
	}
	
	
}
