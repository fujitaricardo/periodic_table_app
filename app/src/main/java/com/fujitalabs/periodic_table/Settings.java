package com.fujitalabs.periodic_table;

import java.util.ArrayList;

public class Settings {
    private static Settings instance;

    // shared preferences
    private int selectedTheme;
    private int selectedLanguage;
    private int selectedScreenRotation;
    private boolean[] selectedCategories;

    // menu
    public final String[] menuRotationOptions = new String[]{"Portrait", "Landscape"};
    public final String[] menuThemeOptions = new String[]{"Light", "Dark"};
    public final String[] menuLanguageOptions = new String[]{"English", "Português"};

    private ArrayList<ChemicalElement> chemicalElements;

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    private Settings() {
        this.chemicalElements = SettingsUtils.getChemicalElementsList();
    }

    public ArrayList<ChemicalElement> getChemicalElements() {
        return chemicalElements;
    }
}
