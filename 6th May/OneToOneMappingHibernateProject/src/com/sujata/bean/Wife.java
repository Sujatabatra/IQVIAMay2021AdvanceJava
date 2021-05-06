package com.sujata.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wife {

	@Id
	private String wifeId;
	private String wifeName;
	@OneToOne
	private Husband husband;
	
	public Wife(){
		
	}

	public Wife(String wifeId, String wifeName) {
		super();
		this.wifeId = wifeId;
		this.wifeName = wifeName;
	}

	public String getWifeId() {
		return wifeId;
	}

	public void setWifeId(String wifeId) {
		this.wifeId = wifeId;
	}

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	
	
}
