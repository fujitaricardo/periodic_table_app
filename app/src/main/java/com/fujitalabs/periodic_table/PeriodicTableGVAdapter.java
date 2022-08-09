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
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class PeriodicTableGVAdapter extends ArrayAdapter<ChemicalElement> {

    private FragmentManager fragmentManager;
    private PeriodTableListener periodTableListener;

    public PeriodicTableGVAdapter(@NonNull Context context, ArrayList<ChemicalElement> ChemicalElementList, PeriodTableListener periodTableListener) {
        super(context, 0, ChemicalElementList);
        this.periodTableListener = periodTableListener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;

        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.element_block_layout, parent, false);
        }

        ChemicalElement chemicalElement = getItem(position);

        if (chemicalElement == null) {
            listitemView.setVisibility(View.GONE);
            listitemView.setEnabled(false);
            listitemView.setClickable(false);
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
                    tvName.setText("Lanthanoids");
                    tvSymbol.setText("");
                    tvAtomicNumber.setText("57-71");
                    tvAtomicWeight.setText("");
                } else if (chemicalElement.getSymbol().equals("Ac")) {
                    tvName.setText("Actinoids");
                    tvSymbol.setText("");
                    tvAtomicNumber.setText("89-103");
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

            if (!chemicalElement.getName().isEmpty()) {
                listitemView.setClickable(true);
                listitemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        periodTableListener.onElementSelected(position);
                    }
                });
            }
        }

        return listitemView;
    }

    public interface PeriodTableListener {
        public void onElementSelected(int selectedElementIndex);
    }
}
