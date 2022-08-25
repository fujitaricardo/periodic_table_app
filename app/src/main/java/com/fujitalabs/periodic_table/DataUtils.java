package com.fujitalabs.periodic_table;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    public static ArrayList<Element> getPeriodicTableArrayList(List<Element> elementsList) {
        ArrayList<Element> periodicTableList = new ArrayList<>();
        for (int i = 0; i < PeriodicTableGVAdapter.GRID_VIEW_SIZE; i++) {
            periodicTableList.add(null);
        }
        for (Element element : elementsList) {
            periodicTableList.set(element.getTablePosition(), element);
        }
        return periodicTableList;
    }
}
