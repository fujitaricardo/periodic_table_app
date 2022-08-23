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

    public static final int[] elementStringIds = {R.string.name_hydrogen, R.string.name_helium, R.string.name_lithium,
            R.string.name_beryllium, R.string.name_boron, R.string.name_carbon, R.string.name_nitrogen, R.string.name_oxygen,
            R.string.name_fluorine, R.string.name_neon, R.string.name_sodium, R.string.name_magnesium, R.string.name_aluminium,
            R.string.name_silicon, R.string.name_phosphorus, R.string.name_sulfur, R.string.name_chlorine, R.string.name_argon,
            R.string.name_potassium, R.string.name_calcium, R.string.name_scandium, R.string.name_titanium, R.string.name_vanadium,
            R.string.name_chromium, R.string.name_manganese, R.string.name_iron, R.string.name_cobalt, R.string.name_nickel,
            R.string.name_copper, R.string.name_zinc, R.string.name_gallium, R.string.name_germanium, R.string.name_arsenic,
            R.string.name_selenium, R.string.name_bromine, R.string.name_krypton, R.string.name_rubidium, R.string.name_strontium,
            R.string.name_yttrium, R.string.name_zirconium, R.string.name_niobium, R.string.name_molybdenum, R.string.name_technetium,
            R.string.name_ruthenium, R.string.name_rhodium, R.string.name_palladium, R.string.name_silver, R.string.name_cadmium,
            R.string.name_indium, R.string.name_tin, R.string.name_antimony, R.string.name_tellurium, R.string.name_iodine,
            R.string.name_xenon, R.string.name_caesium, R.string.name_barium, R.string.name_lanthanum, R.string.name_cerium,
            R.string.name_praseodymium, R.string.name_neodymium, R.string.name_promethium, R.string.name_samarium,
            R.string.name_europium, R.string.name_gadolinium, R.string.name_terbium, R.string.name_dysprosium, R.string.name_holmium,
            R.string.name_erbium, R.string.name_thulium, R.string.name_ytterbium, R.string.name_lutetium, R.string.name_hafnium,
            R.string.name_tantalum, R.string.name_tungsten, R.string.name_rhenium, R.string.name_osmium, R.string.name_iridium,
            R.string.name_platinum, R.string.name_gold, R.string.name_mercury, R.string.name_thallium, R.string.name_lead,
            R.string.name_bismuth, R.string.name_polonium, R.string.name_astatine, R.string.name_radon, R.string.name_francium,
            R.string.name_radium, R.string.name_actinium, R.string.name_thorium, R.string.name_protactinium, R.string.name_uranium,
            R.string.name_neptunium, R.string.name_plutonium, R.string.name_americium, R.string.name_curium, R.string.name_berkelium,
            R.string.name_californium, R.string.name_einsteinium, R.string.name_fermium, R.string.name_mendelevium,
            R.string.name_nobelium, R.string.name_lawrencium, R.string.name_rutherfordium, R.string.name_dubnium, R.string.name_seaborgium,
            R.string.name_bohrium, R.string.name_hassium, R.string.name_meitnerium, R.string.name_darmstadtium, R.string.name_roentgenium,
            R.string.name_copernicium, R.string.name_nihonium, R.string.name_flerovium, R.string.name_moscovium, R.string.name_livermorium,
            R.string.name_tennessine, R.string.name_oganesson};

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
