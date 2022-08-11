package com.fujitalabs.periodic_table;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class PeriodicTableGVAdapter extends ArrayAdapter<ChemicalElement> {

    private ElementSelectedListener periodTableListener;

    public PeriodicTableGVAdapter(@NonNull Context context, ArrayList<ChemicalElement> ChemicalElementList, ElementSelectedListener periodTableListener) {
        super(context, 0, ChemicalElementList);
        this.periodTableListener = periodTableListener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ChemicalElement chemicalElement = getItem(position);
        View elementView = convertView;

        if (elementView == null) {
            elementView = LayoutInflater.from(getContext()).inflate(R.layout.element_card_layout, parent, false);
        }

        CardView cvElementCard = elementView.findViewById(R.id.cv_element_card);
        TextView tvName = elementView.findViewById(R.id.tv_name);
        TextView tvSymbol = elementView.findViewById(R.id.tv_symbol);
        TextView tvAtomicNumber = elementView.findViewById(R.id.tv_atomic_number);
        TextView tvAtomicWeight = elementView.findViewById(R.id.tv_atomic_weight);

        if (position == 92) {
            cvElementCard.setCardBackgroundColor(parent.getResources()
                    .getColor(ChemicalElement.getColorByCategory(ChemicalElement.Category.LANTHANIDES)));
            tvName.setText("Lanthanides");
            tvAtomicNumber.setText("57-71");
            tvSymbol.setText("");
            tvAtomicWeight.setText("");
            elementView.setEnabled(true);
            elementView.setClickable(false);
            elementView.setVisibility(View.VISIBLE);
        } else if (position == 110) {
            cvElementCard.setCardBackgroundColor(parent.getResources()
                    .getColor(ChemicalElement.getColorByCategory(ChemicalElement.Category.ACTINIDES)));
            tvName.setText("Actinides");
            tvAtomicNumber.setText("89-103");
            tvSymbol.setText("");
            tvAtomicWeight.setText("");
            elementView.setEnabled(true);
            elementView.setClickable(false);
            elementView.setVisibility(View.VISIBLE);
        } else if (chemicalElement == null) {
            elementView.setEnabled(false);
            elementView.setClickable(false);
            elementView.setVisibility(View.GONE);
        } else {
            cvElementCard.setCardBackgroundColor(parent.getResources().getColor(chemicalElement.getColor()));
            tvName.setText(chemicalElement.getName());
            tvSymbol.setText(chemicalElement.getSymbol());
            tvAtomicNumber.setText(Integer.toString(chemicalElement.getAtomicNumber()));
            if (chemicalElement.getAtomicWeight() == -1) {
                tvAtomicWeight.setText("unknown");
            } else {
                tvAtomicWeight.setText(Float.toString(chemicalElement.getAtomicWeight()));
            }

            elementView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    periodTableListener.onElementSelected(chemicalElement);
                }
            });

            elementView.setEnabled(true);
            elementView.setClickable(true);
            elementView.setVisibility(View.VISIBLE);
        }

        return elementView;
    }

    public interface ElementSelectedListener {
        void onElementSelected(ChemicalElement selectedElement);
    }
}
