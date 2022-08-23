package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.Intent;
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

public class PeriodicTableGVAdapter extends ArrayAdapter<Element> {

    public static final int gvSize = 180;

    private ElementSelectedListener periodTableListener;
    private Settings settings;

    public PeriodicTableGVAdapter(@NonNull Context context, ArrayList<Element> elementList, ElementSelectedListener periodTableListener) {
        super(context, 0, elementList);
        this.periodTableListener = periodTableListener;
        this.settings = MainActivity.getSettings();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Element element = getItem(position);
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
            cvElementCard.setCardBackgroundColor(parent.getResources().getColor(getCardColor(Element.CATEGORY_LANTHANIDES)));
            tvName.setText(getContext().getString(R.string.category_lanthanides));
            tvAtomicNumber.setText(getContext().getString(R.string.label_lanthanides_range));
            tvSymbol.setText("");
            tvAtomicWeight.setText("");
            elementView.setEnabled(true);
            elementView.setClickable(false);
            elementView.setVisibility(View.VISIBLE);
        } else if (position == 110) {
            cvElementCard.setCardBackgroundColor(parent.getResources().getColor(getCardColor(Element.CATEGORY_ACTINIDES)));
            tvName.setText(getContext().getString(R.string.category_actinides));
            tvAtomicNumber.setText(getContext().getString(R.string.label_actinides_range));
            tvSymbol.setText("");
            tvAtomicWeight.setText("");
            elementView.setEnabled(true);
            elementView.setClickable(false);
            elementView.setVisibility(View.VISIBLE);
        } else if (element == null) {
            elementView.setEnabled(false);
            elementView.setClickable(false);
            elementView.setVisibility(View.GONE);
        } else {
            cvElementCard.setCardBackgroundColor(parent.getResources().getColor(getCardColor(element.getCategory())));
            tvName.setText(Element.elementStringIds[element.getAtomicNumber()-1]);
            tvSymbol.setText(element.getSymbol());
            tvAtomicNumber.setText(Integer.toString(element.getAtomicNumber()));

            elementView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.on_click));
                    periodTableListener.onElementSelected(element);
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

    private int getCardColor(String category) {
        switch (category) {
            case Element.CATEGORY_NONMETALS:
                return settings.isNonMetalsChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_NONMETALS) : R.color.unselected;
            case Element.CATEGORY_ALKALI_METALS:
                return settings.isAlkaliMetalsCheck() ?
                        Element.getColorByCategory(Element.CATEGORY_ALKALI_METALS) : R.color.unselected;
            case Element.CATEGORY_ALKALINE_EARTH_METALS:
                return settings.isAlkalineEarthMetalsChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_ALKALINE_EARTH_METALS) : R.color.unselected;
            case Element.CATEGORY_TRANSITION_METALS:
                return settings.isTransitionMetalsChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_TRANSITION_METALS) : R.color.unselected;
            case Element.CATEGORY_POST_TRANSITION_METALS:
                return settings.isPostTransitionMetalsChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_POST_TRANSITION_METALS) : R.color.unselected;
            case Element.CATEGORY_METALLOIDS:
                return settings.isMetalloidsChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_METALLOIDS) : R.color.unselected;
            case Element.CATEGORY_LANTHANIDES:
                return settings.isLanthanidesChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_LANTHANIDES) : R.color.unselected;
            case Element.CATEGORY_ACTINIDES:
                return settings.isActinidesChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_ACTINIDES) : R.color.unselected;
            case Element.CATEGORY_HALOGENS:
                return settings.isHalogensChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_HALOGENS) : R.color.unselected;
            case Element.CATEGORY_NOBLE_GASES:
                return settings.isNobleGasesChecked() ?
                        Element.getColorByCategory(Element.CATEGORY_NOBLE_GASES) : R.color.unselected;
            default:
                return R.color.unselected;
        }
    }

    public interface ElementSelectedListener {
        void onElementSelected(Element selectedElement);
    }
}
