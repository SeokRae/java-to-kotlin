package com.example.travelator.beansToValue.kotlin.version3

class Application(
    private var preferences: UserPreferences,
) {
    fun showWelcome() {
        WelcomeView(preferences).show()
    }

    fun editPreferences() {
        preferences = PreferencesView().showModel(preferences)
    }
}