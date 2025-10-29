package com.jad.ch02.cdi.qualified;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
@Premium
public class ClientePremium extends Cliente{
	private Integer discountCode;

	public Integer getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(Integer discountCode) {
		this.discountCode = discountCode;
	}
	
	
}
