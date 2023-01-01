package com.example.travelator._11methodtoproperty.v9.java;

public class CampSite {
	private final String id;
	private final String name;
	private final Address address;
	
	public CampSite(String id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public String getCountryCode() {
		return address.getCountryCode();
	}
	
	public String region() {
		return address.getRegion();
	}
}
