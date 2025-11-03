package com.jad.ch02.cdi.event;

import java.io.Serializable;

import com.jad.ch02.cdi.event.model.Cus;

/**
 * Pojo NavigationInfo
 */
public class NavigationInfo implements Serializable{
	private String page;
	private Cus	customer;
	
	public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    public Cus getCustomer() {
    	return customer;
    }
    
    public void setCustomer(Cus customer) {
    	this.customer = customer;	
    }

}
