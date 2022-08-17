package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class Settings {
    private static Settings instance;

    // menu
    public final static String[] menuThemeOptions = new String[]{"Light", "Dark"};
    public final static String[] menuLanguageOptions = new String[]{"English", "Português"};

    // shared preferences
    private SharedPreferences sharedPreferences;
    private String settings = "settings";
    private String isDarkModeKey = "is_dark_mode";
    private String selectedLanguageKey = "selected_language";
    private String isHorizontalOrientationKey = "is_horizontal_orientation";
    private String selectedCategoriesKey = "selected_categories";
    private boolean isDarkMode;
    private boolean isHorizontalOrientation;
    private int selectedLanguage;
    private boolean[] selectedCategories;

    private ArrayList<ChemicalElement> chemicalElements;

    public static Settings getInstance(Context context) {
        if (instance == null) {
            instance = new Settings(context);
        }
        return instance;
    }

    private Settings(Context context) {
        this.sharedPreferences = context.getSharedPreferences(settings, Context.MODE_PRIVATE);
        this.chemicalElements = SettingsUtils.getChemicalElementsList();
        retrieveDataFromSharedPrefs();
    }

    private void retrieveDataFromSharedPrefs() {
        this.isDarkMode = sharedPreferences.getBoolean(isDarkModeKey, false);
        this.isHorizontalOrientation = sharedPreferences.getBoolean(isHorizontalOrientationKey, false);
        this.selectedLanguage = sharedPreferences.getInt(selectedLanguageKey, 0);
    }

    public ArrayList<ChemicalElement> getChemicalElements() {
        return chemicalElements;
    }

    public synchronized boolean isDarkMode() {
        return isDarkMode;
    }

    public synchronized void setDarkMode(boolean darkMode) {
        isDarkMode = darkMode;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(isDarkModeKey, darkMode);
        editor.apply();
    }

    public synchronized int getSelectedLanguage() {
        return selectedLanguage;
    }

    public synchronized void setSelectedLanguage(int selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(selectedLanguageKey, selectedLanguage);
        editor.apply();
    }

    public synchronized boolean isHorizontalOrientation() {
        return isHorizontalOrientation;
    }

    public synchronized void setHorizontalOrientation(boolean isHorizontalOrientation) {
        this.isHorizontalOrientation = isHorizontalOrientation;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(isHorizontalOrientationKey, isHorizontalOrientation);
        editor.apply();
    }

    public synchronized boolean[] getSelectedCategories() {
        return selectedCategories;
    }

    public synchronized void setSelectedCategories(boolean[] selectedCategories) {
        this.selectedCategories = selectedCategories;
    }
}
