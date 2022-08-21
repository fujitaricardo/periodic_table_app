package com.fujitalabs.periodic_table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.HashMap;
import java.util.Map;

@Entity(tableName = "elements")
public class Element {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "table_position")
    private Integer tablePosition;

    @ColumnInfo(name = "atomic_number")
    private Integer atomicNumber;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "symbol")
    private String symbol;

    @ColumnInfo(name = "atomic_weight")
    private String atomicWeight;

    @ColumnInfo(name = "electrons")
    private Integer electrons;

    @ColumnInfo(name = "protons")
    private Integer protons;

    @ColumnInfo(name = "neutrons")
    private Integer neutrons;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "group")
    private Integer group;

    @ColumnInfo(name = "period")
    private Integer period;

    @ColumnInfo(name = "block")
    private String block;

    @ColumnInfo(name = "electron_configuration")
    private String electronConfiguration;

    @ColumnInfo(name = "cas_number")
    private String casNumber;

    @ColumnInfo(name = "density")
    private String density;

    @ColumnInfo(name = "melting")
    private String melting;

    @ColumnInfo(name = "boiling")
    private String boiling;

    @ColumnInfo(name = "state")
    private String state;

    @ColumnInfo(name = "oxidation_states")
    private String oxidationStates;

    @ColumnInfo(name = "electronegativity")
    private String electronegativity;

    @ColumnInfo(name = "electrons_per_shell")
    private Integer electronsPerShell;

    @ColumnInfo(name = "radioactive")
    private Integer radioactive;

    public static final String CATEGORY_NONMETALS = "NONMETALS";
    public static final String CATEGORY_ALKALI_METALS = "ALKALI_METALS";
    public static final String CATEGORY_ALKALINE_EARTH_METALS = "ALKALINE_EARTH_METALS";
    public static final String CATEGORY_TRANSITION_METALS = "TRANSITION_METALS";
    public static final String CATEGORY_POST_TRANSITION_METALS = "POST_TRANSITION_METALS";
    public static final String CATEGORY_METALLOIDS = "METALLOIDS";
    public static final String CATEGORY_LANTHANIDES = "LANTHANIDES";
    public static final String CATEGORY_ACTINIDES = "ACTINIDES";
    public static final String CATEGORY_HALOGENS = "HALOGENS";
    public static final String CATEGORY_NOBLE_GASES = "NOBLE_GASES";

    private static final Map<String, Integer> categoryColor;
    static {
        categoryColor = new HashMap<>();
        categoryColor.put(CATEGORY_NONMETALS, R.color.nonMetals);
        categoryColor.put(CATEGORY_ALKALI_METALS, R.color.alkaliMetals);
        categoryColor.put(CATEGORY_ALKALINE_EARTH_METALS, R.color.alkalineEarthMetals);
        categoryColor.put(CATEGORY_TRANSITION_METALS, R.color.transitionMetals);
        categoryColor.put(CATEGORY_POST_TRANSITION_METALS, R.color.postTransitionMetals);
        categoryColor.put(CATEGORY_METALLOIDS, R.color.metalloids);
        categoryColor.put(CATEGORY_LANTHANIDES, R.color.lanthanides);
        categoryColor.put(CATEGORY_ACTINIDES, R.color.actinides);
        categoryColor.put(CATEGORY_HALOGENS, R.color.halogens);
        categoryColor.put(CATEGORY_NOBLE_GASES, R.color.nobleGases);
    }

    public static Integer getColorByCategory(String category) {
        return categoryColor.get(category);
    }

    // Default getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(Integer tablePosition) {
        this.tablePosition = tablePosition;
    }

    public Integer getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(Integer atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAtomicWeight() {
        return atomicWeight;
    }

    public void setAtomicWeight(String atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public Integer getElectrons() {
        return electrons;
    }

    public void setElectrons(Integer electrons) {
        this.electrons = electrons;
    }

    public Integer getProtons() {
        return protons;
    }

    public void setProtons(Integer protons) {
        this.protons = protons;
    }

    public Integer getNeutrons() {
        return neutrons;
    }

    public void setNeutrons(Integer neutrons) {
        this.neutrons = neutrons;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getElectronConfiguration() {
        return electronConfiguration;
    }

    public void setElectronConfiguration(String electronConfiguration) {
        this.electronConfiguration = electronConfiguration;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getMelting() {
        return melting;
    }

    public void setMelting(String melting) {
        this.melting = melting;
    }

    public String getBoiling() {
        return boiling;
    }

    public void setBoiling(String boiling) {
        this.boiling = boiling;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOxidationStates() {
        return oxidationStates;
    }

    public void setOxidationStates(String oxidationStates) {
        this.oxidationStates = oxidationStates;
    }

    public String getElectronegativity() {
        return electronegativity;
    }

    public void setElectronegativity(String electronegativity) {
        this.electronegativity = electronegativity;
    }

    public Integer getElectronsPerShell() {
        return electronsPerShell;
    }

    public void setElectronsPerShell(Integer electronsPerShell) {
        this.electronsPerShell = electronsPerShell;
    }

    public Integer getRadioactive() {
        return radioactive;
    }

    public void setRadioactive(Integer radioactive) {
        this.radioactive = radioactive;
    }
}
