package com.jad.ch02.cdi.scopes;

import java.io.Serializable;

import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientInfoController implements Serializable{
	
	@Inject
	private Conversation conversation;
	@Inject
	private Client customer;
	
	public String customerInfoEntry(){
		conversation.begin();
		System.out.println(customer);
		return "page1";
	}
	
	public String navigateToPage1() {
        System.out.println(customer);
        return "page1";
    }

    public String navigateToPage2() {
        System.out.println(customer);
        return "page2";
    }

    public String navigateToPage3() {
        System.out.println(customer);
        return "page3";
    }

    public String navigateToConfirmationPage() {
        System.out.println(customer);
        conversation.end();
        return "confirmation";
    }
}
