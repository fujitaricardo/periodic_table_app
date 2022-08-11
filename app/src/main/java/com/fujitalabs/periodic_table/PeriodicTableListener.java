package com.fujitalabs.periodic_table;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onElementSelected(ChemicalElement chemicalElement) {
        TextView name = bsElementSheet.findViewById(R.id.tv_name);
        TextView symbol = bsElementSheet.findViewById(R.id.tv_symbol);
        TextView atomicNumber = bsElementSheet.findViewById(R.id.tv_atomic_number);
        TextView atomicWeight = bsElementSheet.findViewById(R.id.tv_atomic_weight);
        TextView seeMore = bsElementSheet.findViewById(R.id.tv_see_more);

        name.setText(chemicalElement.getName());
        symbol.setText(chemicalElement.getSymbol());
        atomicNumber.setText(Integer.toString(chemicalElement.getAtomicNumber()));

        if (chemicalElement.getAtomicWeight() == -1) {
            atomicWeight.setText("unknown");
        } else {
            atomicWeight.setText(Float.toString(chemicalElement.getAtomicWeight()));
        }

        seeMore.setText("SEE MORE");
        seeMore.setClickable(true);
        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "See More", Toast.LENGTH_SHORT).show();
            }
        });

        bsElementSheet.setVisibility(View.VISIBLE);
        bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
