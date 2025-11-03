package com.jad.ch02.cdi.event.controller;

import java.io.Serializable;

import com.jad.ch02.cdi.event.NavigationInfo;
import com.jad.ch02.cdi.event.model.Cus;

import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Cada metodo de la clase activa la navegacion de una pagina a otra
 * Cada vez que navegamos a una nueva pagina se activa un evento CDI
 */
@Named
@RequestScoped
public class CustomerInfoController implements Serializable {
	@Inject
	private Conversation conversation;
	
	@Inject
	private Cus customer;
	
	@Inject
	private Event<NavigationInfo> navigationInfoEvent;
	
	public String customerInfoEntry() {
		conversation.begin();
		NavigationInfo navigationInfo = new NavigationInfo();
		navigationInfo.setPage("1");
		navigationInfo.setCustomer(customer);
		
		navigationInfoEvent.fire(navigationInfo);
		return "page1";
		
	}
	
	public String navigateToPage1() {
        NavigationInfo navigationInfo = new NavigationInfo();
        navigationInfo.setPage("1");
        navigationInfo.setCustomer(customer);

        navigationInfoEvent.fire(navigationInfo);

        return "page1";
    }
	
	public String navigateToPage2() {
        NavigationInfo navigationInfo = new NavigationInfo();
        navigationInfo.setPage("2");
        navigationInfo.setCustomer(customer);

        navigationInfoEvent.fire(navigationInfo);
        return "page2";
    }
	
	public String navigateToPage3() {
        NavigationInfo navigationInfo = new NavigationInfo();
        navigationInfo.setPage("3");
        navigationInfo.setCustomer(customer);

        navigationInfoEvent.fire(navigationInfo);
        return "page3";
    }
	
	public String navigateToConfirmationPage() {
        NavigationInfo navigationInfo = new NavigationInfo();
        navigationInfo.setPage("confirmation");
        navigationInfo.setCustomer(customer);

        navigationInfoEvent.fire(navigationInfo);
        conversation.end();
        return "confirmation";
    }
}
