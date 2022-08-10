package com.fujitalabs.periodic_table;

import java.util.HashMap;
import java.util.Map;

public class ChemicalElement {
    private String name;
    private String symbol;
    private int atomicNumber;
    private int group;
    private int period;
    private String block;
    private float atomicWeight;
    private Category category;
    private String CASNumber;

    public enum Category {
        NONMETALS,
        ALKALI_METALS,
        ALKALINE_EARTH_METALS,
        TRANSITION_METALS,
        POST_TRANSITION_METALS,
        METALLOIDS,
        LANTHANIDES,
        ACTINIDES,
        HALOGENS,
        NOBLE_GASES
    }

    private static final Map<Category, Integer> categoryColor;
    static {
        categoryColor = new HashMap<>();
        categoryColor.put(Category.NONMETALS, R.color.green_pastel);
        categoryColor.put(Category.ALKALI_METALS, R.color.red_pastel);
        categoryColor.put(Category.ALKALINE_EARTH_METALS, R.color.brown);
        categoryColor.put(Category.TRANSITION_METALS, R.color.orange_dark);
        categoryColor.put(Category.POST_TRANSITION_METALS, R.color.teal_200);
        categoryColor.put(Category.METALLOIDS, R.color.yellow);
        categoryColor.put(Category.LANTHANIDES, R.color.pink);
        categoryColor.put(Category.ACTINIDES, R.color.purple);
        categoryColor.put(Category.HALOGENS, R.color.blue_pastel);
        categoryColor.put(Category.NOBLE_GASES, R.color.silver);
    }

    public ChemicalElement(String name, String symbol, int atomicNumber, float atomicWeight, Category category) {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
        this.category = category;
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

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public float getAtomicWeight() {
        return atomicWeight;
    }

    public void setAtomicWeight(float atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCASNumber() {
        return CASNumber;
    }

    public void setCASNumber(String CASNumber) {
        this.CASNumber = CASNumber;
    }

    public Integer getColor() {
        return categoryColor.get(this.category);
    }

    public static Integer getColorByCategory(Category category) {
        return categoryColor.get(category);
    }
}
