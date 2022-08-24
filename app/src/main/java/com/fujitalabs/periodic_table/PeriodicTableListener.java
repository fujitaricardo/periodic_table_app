package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.Intent;
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
        ImageButton readMore = bsElementSheet.findViewById(R.id.ib_read_more);

        name.setText(Element.elementStringIds[element.getAtomicNumber()-1]);
        name.setBackground(context.getDrawable(Element.categoryGradient.get(element.getCategory())));
        atomicNumber.setText(Integer.toString(element.getAtomicNumber()));
        atomicWeight.setText(element.getAtomicWeight());

        readMore.setClickable(true);
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ElementDataActivity.class);
                context.startActivity(intent);
            }
        });

        bsElementSheet.setVisibility(View.VISIBLE);
        bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
