package com.example.travelator._10functiontoextentionfunction.v1.java;

public class CustomerData {
	private final String id;
	private final String givenName;
	private final String familyName;
	private final int score;
	private final double spend;
	
	public CustomerData(String id, String givenName, String familyName, int score, double spend) {
		this.id = id;
		this.givenName = givenName;
		this.familyName = familyName;
		this.score = score;
		this.spend = spend;
	}
	
	public String getId() {
		return id;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public int getScore() {
		return score;
	}
	
	public double getSpend() {
		return spend;
	}
}
