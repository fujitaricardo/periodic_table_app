package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class PeriodicTableListener implements PeriodicTableGVAdapter.ElementSelectedListener {

    private Context context;
    private ViewGroup bsElementSheet;
    private BottomSheetBehavior bsElementSheetBehavior;

    public PeriodicTableListener(Context context, ViewGroup bsElementSheet, BottomSheetBehavior bsElementSheetBehavior) {
        this.context = context;
        this.bsElementSheet = bsElementSheet;
        this.bsElementSheetBehavior = bsElementSheetBehavior;
    }

    @Override
    public void onElementSelected(Element element) {
        TextView name = bsElementSheet.findViewById(R.id.tv_element_name);
        TextView atomicNumber = bsElementSheet.findViewById(R.id.tv_atomic_number);
        TextView atomicWeight = bsElementSheet.findViewById(R.id.tv_atomic_weight);
        TextView electrons = bsElementSheet.findViewById(R.id.tv_electrons);
        TextView protons = bsElementSheet.findViewById(R.id.tv_protons);
        TextView neutrons = bsElementSheet.findViewById(R.id.tv_neutrons);
        TextView latinName = bsElementSheet.findViewById(R.id.tv_latin_name);
        TextView symbol = bsElementSheet.findViewById(R.id.tv_symbol);
        TextView group = bsElementSheet.findViewById(R.id.tv_group);
        TextView period = bsElementSheet.findViewById(R.id.tv_period);
        TextView block = bsElementSheet.findViewById(R.id.tv_block);
        TextView category = bsElementSheet.findViewById(R.id.tv_category);
        TextView casNumber = bsElementSheet.findViewById(R.id.tv_cas_number);
        ImageButton readMore = bsElementSheet.findViewById(R.id.ib_read_more);

        name.setText(Element.elementStringIds[element.getAtomicNumber()-1]);
        name.setBackground(context.getDrawable(Element.categoryGradient.get(element.getCategory())));
        atomicNumber.setText(Integer.toString(element.getAtomicNumber()));
        atomicWeight.setText(element.getAtomicWeight());
        electrons.setText(Integer.toString(element.getElectrons()));
        protons.setText(Integer.toString(element.getProtons()));
        neutrons.setText(Integer.toString(element.getNeutrons()));
        latinName.setText(element.getLatinName());
        symbol.setText(element.getSymbol());
        group.setText(element.getGroup());
        period.setText(element.getPeriod());
        block.setText(element.getBlock());
        category.setText(Element.categoryName.get(element.getCategory()));
        casNumber.setText(element.getCasNumber());

        readMore.setClickable(true);
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ElementDataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(ElementDataActivity.ELEMENT_EXTRA, element.getAtomicNumber());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        bsElementSheet.setVisibility(View.VISIBLE);
        bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
