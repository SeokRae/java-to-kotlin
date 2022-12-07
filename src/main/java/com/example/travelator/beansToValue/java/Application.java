package com.example.travelator.beansToValue.java;

public class Application {
	private final UserPreferences preferences;
	
	public Application(UserPreferences preferences) {
		this.preferences = preferences;
	}
	
	/**
	 * preferences 가 아니라 this를 넘겨야 함!!!!
	 */
	public void showWelcome() {
		new WelcomeView(preferences).show();
	}
	
	public void editPreferences() {
		new PreferencesView(preferences).show();
	}
}
