package com.fujitalabs.periodic_table;

import java.util.ArrayList;

public class SettingsUtils {

    public static ArrayList<ChemicalElement> getChemicalElementsList() {
        ArrayList<ChemicalElement> chemicalElements = new ArrayList<>();
        chemicalElements.add(new ChemicalElement("Hydrogen", "H", 1, 1.008f, ChemicalElement.Category.NONMETALS));
        addNullElements(chemicalElements, 16);
        chemicalElements.add(new ChemicalElement("Helium", "He", 2, 4.002602f, ChemicalElement.Category.NOBLE_GASES));

        chemicalElements.add(new ChemicalElement("Lithium", "Li", 3, 6.94f, ChemicalElement.Category.ALKALI_METALS));
        chemicalElements.add(new ChemicalElement("Beryllium", "Be", 4, 9.0121831f, ChemicalElement.Category.ALKALINE_EARTH_METALS));
        addNullElements(chemicalElements, 10);
        chemicalElements.add(new ChemicalElement("Boron", "B", 5, 10.81f, ChemicalElement.Category.METALLOIDS));
        chemicalElements.add(new ChemicalElement("Carbon", "C", 6, 12.001f, ChemicalElement.Category.NONMETALS));
        chemicalElements.add(new ChemicalElement("Nitrogen", "N", 7, 14.007f, ChemicalElement.Category.NONMETALS));
        chemicalElements.add(new ChemicalElement("Oxygen", "O", 8, 15.999f, ChemicalElement.Category.NONMETALS));
        chemicalElements.add(new ChemicalElement("Fluorine", "F", 9, 18.998f, ChemicalElement.Category.HALOGENS));
        chemicalElements.add(new ChemicalElement("Neon", "Ne", 10, 20.180f, ChemicalElement.Category.NOBLE_GASES));

        chemicalElements.add(new ChemicalElement("Sodium", "Na", 11, 22.990f, ChemicalElement.Category.ALKALI_METALS));
        chemicalElements.add(new ChemicalElement("Magnesium", "Mg", 12, 24.305f, ChemicalElement.Category.ALKALINE_EARTH_METALS));
        addNullElements(chemicalElements, 10);
        chemicalElements.add(new ChemicalElement("Aluminium", "Al", 13, 26.982f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Silicon", "Si", 14, 28.086f, ChemicalElement.Category.METALLOIDS));
        chemicalElements.add(new ChemicalElement("Phosphorus", "P", 15, 30.974f, ChemicalElement.Category.NONMETALS));
        chemicalElements.add(new ChemicalElement("Sulfur", "S", 16, 32.066f, ChemicalElement.Category.NONMETALS));
        chemicalElements.add(new ChemicalElement("Chlorine", "Cl", 17, 35.453f, ChemicalElement.Category.HALOGENS));
        chemicalElements.add(new ChemicalElement("Argon", "Ar", 18, 39.948f, ChemicalElement.Category.NOBLE_GASES));

        chemicalElements.add(new ChemicalElement("Potassium", "K", 19, 39.098f, ChemicalElement.Category.ALKALI_METALS));
        chemicalElements.add(new ChemicalElement("Calcium", "Ca", 20, 40.078f, ChemicalElement.Category.ALKALINE_EARTH_METALS));
        chemicalElements.add(new ChemicalElement("Scandium", "Sc", 21, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Titanium", "Ti", 22, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Vanadium", "V", 23, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Chromium", "Cr", 24, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Manganese", "Mn", 25, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Iron", "Fe", 26, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Cobalt", "Co", 27, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Nickel", "Ni", 28, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Copper", "Cu", 29, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Zinc", "Zn", 30, 44.956f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Gallium", "Ga", 31, 69.723f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Germanium", "Ge", 32, 72.631f, ChemicalElement.Category.METALLOIDS));
        chemicalElements.add(new ChemicalElement("Arsenic", "As", 33, 74.922f, ChemicalElement.Category.METALLOIDS));
        chemicalElements.add(new ChemicalElement("Selenium", "Se", 34, 78.972f, ChemicalElement.Category.NONMETALS));
        chemicalElements.add(new ChemicalElement("Bromine", "Br", 35, 79.904f, ChemicalElement.Category.HALOGENS));
        chemicalElements.add(new ChemicalElement("Krypton", "Kr", 36, 84.798f, ChemicalElement.Category.NOBLE_GASES));

        chemicalElements.add(new ChemicalElement("Rubidium", "Rb", 37, 85.468f, ChemicalElement.Category.ALKALI_METALS));
        chemicalElements.add(new ChemicalElement("Strontium", "Sr", 38, 87.620f, ChemicalElement.Category.ALKALINE_EARTH_METALS));
        chemicalElements.add(new ChemicalElement("Yttrium", "Y", 39, 88.906f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Zirconium", "Zr", 40, 91.224f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Niobium", "Nb", 41, 92.906f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Molybdenum", "Mo", 42, 92.906f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Technetium", "Tc", 43, 98.907f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Ruthenium", "Ru", 44, 101.070f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Rhodium", "Rh", 45, 102.9062f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Palladium", "Pd", 46, 106.42f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Silver", "Ag", 47, 107.868f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Cadmium", "Cd", 48, 112.411f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Indium", "In", 49, 114.818f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Tin", "Sn", 50, 118.711f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Antimony", "Sb", 51, 121.760f, ChemicalElement.Category.METALLOIDS));
        chemicalElements.add(new ChemicalElement("Tellurium", "Te", 52, 127.6f, ChemicalElement.Category.METALLOIDS));
        chemicalElements.add(new ChemicalElement("Iodine", "I", 53, 126.904f, ChemicalElement.Category.HALOGENS));
        chemicalElements.add(new ChemicalElement("Xenon", "Xe", 54, 131.294f, ChemicalElement.Category.NOBLE_GASES));

        chemicalElements.add(new ChemicalElement("Cesium", "Cs", 55, 132.905f, ChemicalElement.Category.ALKALI_METALS));
        chemicalElements.add(new ChemicalElement("Barium", "Ba", 56, 137.328f, ChemicalElement.Category.ALKALINE_EARTH_METALS));
        addNullElements(chemicalElements, 1); // Lanthanides
        chemicalElements.add(new ChemicalElement("Hafnium", "Hf", 72, 178.49f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Tantalum", "Ta", 73, 180.948f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Tungsten", "W", 74, 183.84f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Rhenium", "Re", 75, 186.207f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Osmium", "Os", 76, 190.23f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Iridium", "Ir", 77, 192.217f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Platinum", "Pt", 78, 195.085f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Gold", "Au", 79, 196.967f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Mercuiry", "Hg", 80, 200.592f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Thallium", "Tl", 81, 204.383f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Lead", "Pb", 82, 207.2f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Bismuth", "Bi", 83, 208.980f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Polonium", "Po", 84, 208.982f, ChemicalElement.Category.METALLOIDS));
        chemicalElements.add(new ChemicalElement("Astatine", "At", 85, 209.987f, ChemicalElement.Category.HALOGENS));
        chemicalElements.add(new ChemicalElement("Radon", "Rn", 86, 222.018f, ChemicalElement.Category.NOBLE_GASES));

        chemicalElements.add(new ChemicalElement("Francium", "Fr", 87, 223.020f, ChemicalElement.Category.ALKALI_METALS));
        chemicalElements.add(new ChemicalElement("Radium", "Ra", 88, 226.025f, ChemicalElement.Category.ALKALINE_EARTH_METALS));
        addNullElements(chemicalElements, 1); // Actinides
        chemicalElements.add(new ChemicalElement("Rutherfordium", "Rf", 104, 261f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Dubnium", "Db", 105, 262f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Seaborgium", "Sg", 106, 266f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Bohrium", "Bh", 107, 264f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Hassium", "Hs", 108, 269f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Meitnerium", "Mt", 109, 268f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Darmstadtium", "Ds", 110, 269f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Roentgenium", "Rg", 111, 272f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Copernicium", "Cn", 112, 277f, ChemicalElement.Category.TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Nihonium", "Nh", 113, -1f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Flerovium", "Fl", 114, 289f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Moscovium", "Mc", 115, -1f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Livermorium", "Lv", 116, 298f, ChemicalElement.Category.POST_TRANSITION_METALS));
        chemicalElements.add(new ChemicalElement("Tennessine", "Ts", 117, -1f, ChemicalElement.Category.HALOGENS));
        chemicalElements.add(new ChemicalElement("Oganesson", "Og", 118, -1f, ChemicalElement.Category.NOBLE_GASES));

        addNullElements(chemicalElements, 18);

        addNullElements(chemicalElements, 2);
        chemicalElements.add(new ChemicalElement("Lanthanum", "La", 57, 138.905f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Cerium", "Ce", 58, 140.116f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Praseodymium", "Pr", 59, 140.908f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Neodymium", "Nd", 60, 144.242f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Promethium", "Pm", 61, 144.242f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Samarium", "Sm", 62, 150.36f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Europium", "Eu", 63, 151.964f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Gadolinium", "Gd", 64, 157.25f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Terbium", "Tb", 65, 158.925f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Dysprosium", "Dy", 66, 162.500f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Holmium", "Ho", 67, 164.930f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Erbium", "Er", 68, 167.259f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Thulium", "Tm", 69, 168.934f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Ytterbium", "Yb", 70, 173.055f, ChemicalElement.Category.LANTHANIDES));
        chemicalElements.add(new ChemicalElement("Lutetium", "Lu", 71, 173.055f, ChemicalElement.Category.LANTHANIDES));
        addNullElements(chemicalElements, 1);

        addNullElements(chemicalElements, 2);
        chemicalElements.add(new ChemicalElement("Actinium", "Ac", 89, 227.028f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Thorium", "Th", 90, 232.038f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Protactinium", "Pa", 91, 231.036f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Uranium", "U", 92, 238.029f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Neptunium", "Np", 93, 237.048f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Plutonium", "Pu", 84, 244.064f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Americium", "Am", 95, 243.061f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Curium", "Cm", 96, 247.070f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Berkelium", "Bk", 97, 247.070f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Californium", "Cf", 98, 251.080f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Einsteinium", "Es", 99, 254f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Fermium", "Fm", 100, 257.095f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Mendelevium", "Md", 101, 258.1f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Nobelium", "No", 102, 259.101f, ChemicalElement.Category.ACTINIDES));
        chemicalElements.add(new ChemicalElement("Lawrencium", "Lr", 103, 262f, ChemicalElement.Category.ACTINIDES));
        addNullElements(chemicalElements, 1);

        return chemicalElements;
    }

    private static void addNullElements(ArrayList<ChemicalElement> chemicalElements, int n) {
        for (int i = 0; i < n; i++) {
            chemicalElements.add(null);
        }
    }
}
