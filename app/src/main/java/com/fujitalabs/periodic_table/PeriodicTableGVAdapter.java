package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.Intent;
import android.location.SettingInjectorService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class PeriodicTableGVAdapter extends ArrayAdapter<ChemicalElement> {

    private ElementSelectedListener periodTableListener;
    private Settings settings;

    public PeriodicTableGVAdapter(@NonNull Context context, ArrayList<ChemicalElement> ChemicalElementList, ElementSelectedListener periodTableListener) {
        super(context, 0, ChemicalElementList);
        this.periodTableListener = periodTableListener;
        this.settings = MainActivity.getSettings();
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
                    .getColor(getCardColor(ChemicalElement.Category.LANTHANIDES)));
            tvName.setText("Lanthanides");
            tvAtomicNumber.setText("57-71");
            tvSymbol.setText("");
            tvAtomicWeight.setText("");
            elementView.setEnabled(true);
            elementView.setClickable(false);
            elementView.setVisibility(View.VISIBLE);
        } else if (position == 110) {
            cvElementCard.setCardBackgroundColor(parent.getResources()
                    .getColor(getCardColor(ChemicalElement.Category.ACTINIDES)));
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
            cvElementCard.setCardBackgroundColor(parent.getResources()
                    .getColor(getCardColor(chemicalElement.getCategory())));
            tvName.setText(chemicalElement.getName());
            tvSymbol.setText(chemicalElement.getSymbol());
            tvAtomicNumber.setText(Integer.toString(chemicalElement.getAtomicNumber()));

            elementView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.on_click));
                    periodTableListener.onElementSelected(chemicalElement);
                }
            });

            elementView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.on_long_click));
                    Intent intent = new Intent(getContext(), ElementDataActivity.class);
                    getContext().startActivity(intent);
                    return false;
                }
            });

            elementView.setEnabled(true);
            elementView.setClickable(true);
            elementView.setVisibility(View.VISIBLE);
        }

        return elementView;
    }

    private int getCardColor(ChemicalElement.Category category) {
        switch (category) {
            case NONMETALS:
                return settings.isNonMetalsChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.NONMETALS) : R.color.unselected;
            case ALKALI_METALS:
                return settings.isAlkaliMetalsCheck() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.ALKALI_METALS) : R.color.unselected;
            case ALKALINE_EARTH_METALS:
                return settings.isAlkalineEarthMetalsChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.ALKALINE_EARTH_METALS) : R.color.unselected;
            case TRANSITION_METALS:
                return settings.isTransitionMetalsChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.TRANSITION_METALS) : R.color.unselected;
            case POST_TRANSITION_METALS:
                return settings.isPostTransitionMetalsChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.POST_TRANSITION_METALS) : R.color.unselected;
            case METALLOIDS:
                return settings.isMetalloidsChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.METALLOIDS) : R.color.unselected;
            case LANTHANIDES:
                return settings.isLanthanidesChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.LANTHANIDES) : R.color.unselected;
            case ACTINIDES:
                return settings.isActinidesChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.ACTINIDES) : R.color.unselected;
            case HALOGENS:
                return settings.isHalogensChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.HALOGENS) : R.color.unselected;
            case NOBLE_GASES:
                return settings.isNobleGasesChecked() ?
                        ChemicalElement.getColorByCategory(ChemicalElement.Category.NOBLE_GASES) : R.color.unselected;
            default:
                return R.color.unselected;
        }
    }

    public interface ElementSelectedListener {
        void onElementSelected(ChemicalElement selectedElement);
    }
}
