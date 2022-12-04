package com.example.travelator.beansToValue.kotlin.version2

class Application(
    private var preferences: UserPreferences
) {
    fun showWelcome() {
        WelcomeView(preferences).show()
    }

    fun editPreferences() {
        preferences = PreferencesView(preferences).showModel()
    }
}