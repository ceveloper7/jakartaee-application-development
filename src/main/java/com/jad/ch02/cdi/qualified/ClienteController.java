package com.jad.ch02.cdi.qualified;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClienteController {
	private static final Logger logger = Logger.getLogger(ClienteController.class.getName());
	
	@Inject
	@Premium
	private Cliente customer;
	
	public String saveCustomer() {
		ClientePremium premiumCustomer = (ClientePremium) customer;
		
		logger.log(Level.INFO, "Saving the following information \n{0} {1}, discount code = {2}",
	            new Object[]{premiumCustomer.getFirstName(), premiumCustomer.getLastName(), premiumCustomer.getDiscountCode()});

	    return "confirmation";
	}
}
