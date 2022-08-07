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

    public PeriodicTableGVAdapter(@NonNull Context context, ArrayList<ChemicalElement> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;

        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.element_block_layout, parent, false);
        }

        listitemView.setClickable(false);
        ChemicalElement chemicalElement = getItem(position);

        if (chemicalElement == null) {
            listitemView.setVisibility(View.GONE);
            listitemView.setEnabled(false);
        } else {
            listitemView.setVisibility(View.VISIBLE);
            listitemView.setEnabled(true);
            CardView cvElementCard = listitemView.findViewById(R.id.cv_element_card);
            TextView tvName = listitemView.findViewById(R.id.tv_name);
            TextView tvSymbol = listitemView.findViewById(R.id.tv_symbol);
            TextView tvAtomicNumber = listitemView.findViewById(R.id.tv_atomic_number);
            TextView tvAtomicWeight = listitemView.findViewById(R.id.tv_atomic_weight);

            cvElementCard.setCardBackgroundColor(parent.getResources().getColor(chemicalElement.getColor()));

            if (chemicalElement.getName().equals("")) {
                if (chemicalElement.getSymbol().equals("La")) {
                    tvAtomicNumber.setText("57-71");
                    tvName.setText("");
                    tvSymbol.setText("");
                    tvAtomicWeight.setText("");
                } else if (chemicalElement.getSymbol().equals("Ac")) {
                    tvAtomicNumber.setText("89-103");
                    tvName.setText("");
                    tvSymbol.setText("");
                    tvAtomicWeight.setText("");
                }
            } else {
                tvName.setText(chemicalElement.getName());
                tvSymbol.setText(chemicalElement.getSymbol());
                tvAtomicNumber.setText(Integer.toString(chemicalElement.getAtomicNumber()));
                if (chemicalElement.getAtomicWeight() == -1) {
                    tvAtomicWeight.setText("unknown");
                } else {
                    tvAtomicWeight.setText(Float.toString(chemicalElement.getAtomicWeight()));
                }
            }
        }

        return listitemView;
    }
}
