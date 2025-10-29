package com.jad.ch02.cdi.scopes;

import java.io.Serializable;

import jakarta.enterprise.context.ConversationScoped;
import jakarta.inject.Named;

@Named
@ConversationScoped
public class Client implements Serializable {
	private String firstName;
	private String middleName;
	private String lastName;
	private String addrLine1;
	private String addrLine2;
	private String addrCity;
	private String state;
	private String zip;
	private String phoneHome;
	private String phoneWork;
	private String phoneMobile;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	public String getAddrCity() {
		return addrCity;
	}
	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	public String getPhoneWork() {
		return phoneWork;
	}
	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("Customer{");
	    sb.append("firstName=").append(firstName);
	    sb.append(", middleName=").append(middleName);
	    sb.append(", lastName=").append(lastName);
	    sb.append(", addrLine1=").append(addrLine1);
	    sb.append(", addrLine2=").append(addrLine2);
	    sb.append(", addrCity=").append(addrCity);
	    sb.append(", state=").append(state);
	    sb.append(", zip=").append(zip);
	    sb.append(", phoneHome=").append(phoneHome);
	    sb.append(", phoneWork=").append(phoneWork);
	    sb.append(", phoneMobile=").append(phoneMobile);
	    sb.append('}');
	    return sb.toString();
	}
}
