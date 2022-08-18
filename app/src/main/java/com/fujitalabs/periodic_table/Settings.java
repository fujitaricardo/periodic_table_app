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
    private boolean isDarkMode;
    private int selectedLanguage;

    // filter
    boolean isFilterOn = false;
    boolean isNonMetalsChecked = true;
    boolean isAlkaliMetalsCheck = true;
    boolean isAlkalineEarthMetalsChecked = true;
    boolean isTransitionMetalsChecked = true;
    boolean isPostTransitionMetalsChecked = true;
    boolean isMetalloidsChecked = true;
    boolean isLanthanidesChecked = true;
    boolean isActinidesChecked = true;
    boolean isHalogensChecked = true;
    boolean isNobleGasesChecked = true;

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

    public boolean isFilterOn() {
        return isFilterOn;
    }

    public void setFilterOn(boolean filterOn) {
        isFilterOn = filterOn;
    }

    public boolean isNonMetalsChecked() {
        return isNonMetalsChecked;
    }

    public void setNonMetalsChecked(boolean nonMetalsChecked) {
        isNonMetalsChecked = nonMetalsChecked;
    }

    public boolean isAlkaliMetalsCheck() {
        return isAlkaliMetalsCheck;
    }

    public void setAlkaliMetalsCheck(boolean alkaliMetalsCheck) {
        isAlkaliMetalsCheck = alkaliMetalsCheck;
    }

    public boolean isAlkalineEarthMetalsChecked() {
        return isAlkalineEarthMetalsChecked;
    }

    public void setAlkalineEarthMetalsChecked(boolean alkalineEarthMetalsChecked) {
        isAlkalineEarthMetalsChecked = alkalineEarthMetalsChecked;
    }

    public boolean isTransitionMetalsChecked() {
        return isTransitionMetalsChecked;
    }

    public void setTransitionMetalsChecked(boolean transitionMetalsChecked) {
        isTransitionMetalsChecked = transitionMetalsChecked;
    }

    public boolean isPostTransitionMetalsChecked() {
        return isPostTransitionMetalsChecked;
    }

    public void setPostTransitionMetalsChecked(boolean postTransitionMetalsChecked) {
        isPostTransitionMetalsChecked = postTransitionMetalsChecked;
    }

    public boolean isMetalloidsChecked() {
        return isMetalloidsChecked;
    }

    public void setMetalloidsChecked(boolean metalloidsChecked) {
        isMetalloidsChecked = metalloidsChecked;
    }

    public boolean isLanthanidesChecked() {
        return isLanthanidesChecked;
    }

    public void setLanthanidesChecked(boolean lanthanidesChecked) {
        isLanthanidesChecked = lanthanidesChecked;
    }

    public boolean isActinidesChecked() {
        return isActinidesChecked;
    }

    public void setActinidesChecked(boolean actinidesChecked) {
        isActinidesChecked = actinidesChecked;
    }

    public boolean isHalogensChecked() {
        return isHalogensChecked;
    }

    public void setHalogensChecked(boolean halogensChecked) {
        isHalogensChecked = halogensChecked;
    }

    public boolean isNobleGasesChecked() {
        return isNobleGasesChecked;
    }

    public void setNobleGasesChecked(boolean nobleGasesChecked) {
        isNobleGasesChecked = nobleGasesChecked;
    }
}
