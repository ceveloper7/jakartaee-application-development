package com.jad.ch02.cdi.listener;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jad.ch02.cdi.event.NavigationInfo;
import com.jad.ch02.cdi.event.model.Cus;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.event.Observes;

@SessionScoped
public class NavigationEventListener implements Serializable{
	private static final Logger LOG = Logger.getLogger(NavigationEventListener.class.getName());
	
	/**
	 * @Observes cada vez que un evento NavigationInfo es disparado CDI invoca el metodo handleNavigationEvent
	 */
	public void handleNavigationEvent(@Observes NavigationInfo navigationInfo) {
		LOG.info("Navigation event fired");
		LOG.log(Level.INFO, "Pager {0}", navigationInfo.getPage());
		LOG.log(Level.INFO, "Customer {0}", navigationInfo.getCustomer());
	}
}
