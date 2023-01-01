package com.example.travelator._11methodtoproperty.v10.java;

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
	// 계산된 프로퍼티
	public String getCountryCode() {
		return address.getCountryCode();
	}
	// 계산된 프로퍼티지만 컨벤션 관습이 지켜지지 않음
	public String region() {
		return address.getRegion();
	}
}
