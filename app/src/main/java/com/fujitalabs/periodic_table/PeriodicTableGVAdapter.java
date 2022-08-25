package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    public static final int GRID_VIEW_SIZE = 240;
    public static final int POSITION_LANTHANIDES = 123;
    public static final int POSITION_ACTINIDES = 143;
    public static final int POSITION_PERIOD_1 = 20;
    public static final int POSITION_PERIOD_2 = 40;
    public static final int POSITION_PERIOD_3 = 60;
    public static final int POSITION_PERIOD_4 = 80;
    public static final int POSITION_PERIOD_5 = 100;
    public static final int POSITION_PERIOD_6 = 120;
    public static final int POSITION_PERIOD_7 = 140;
    public static final int POSITION_GROUP_1 = 1;
    public static final int POSITION_GROUP_2 = 22;
    public static final int POSITION_GROUP_3 = 63;
    public static final int POSITION_GROUP_4 = 64;
    public static final int POSITION_GROUP_5 = 65;
    public static final int POSITION_GROUP_6 = 66;
    public static final int POSITION_GROUP_7 = 67;
    public static final int POSITION_GROUP_8 = 68;
    public static final int POSITION_GROUP_9 = 69;
    public static final int POSITION_GROUP_10 = 70;
    public static final int POSITION_GROUP_11 = 71;
    public static final int POSITION_GROUP_12 = 72;
    public static final int POSITION_GROUP_13 = 33;
    public static final int POSITION_GROUP_14 = 34;
    public static final int POSITION_GROUP_15 = 35;
    public static final int POSITION_GROUP_16 = 36;
    public static final int POSITION_GROUP_17 = 37;
    public static final int POSITION_GROUP_18 = 18;


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
        View view = convertView;
        Element element = getItem(position);

        switch (position) {
            case POSITION_PERIOD_1:
            case POSITION_PERIOD_2:
            case POSITION_PERIOD_3:
            case POSITION_PERIOD_4:
            case POSITION_PERIOD_5:
            case POSITION_PERIOD_6:
            case POSITION_PERIOD_7:
                return getPeriodView(view, position, parent);
            case POSITION_GROUP_1:
            case POSITION_GROUP_2:
            case POSITION_GROUP_3:
            case POSITION_GROUP_4:
            case POSITION_GROUP_5:
            case POSITION_GROUP_6:
            case POSITION_GROUP_7:
            case POSITION_GROUP_8:
            case POSITION_GROUP_9:
            case POSITION_GROUP_10:
            case POSITION_GROUP_11:
            case POSITION_GROUP_12:
            case POSITION_GROUP_13:
            case POSITION_GROUP_14:
            case POSITION_GROUP_15:
            case POSITION_GROUP_16:
            case POSITION_GROUP_17:
            case POSITION_GROUP_18:
                return getGroupView(view, position, parent);
            case POSITION_LANTHANIDES:
                return getLanthanidesView(view, parent);
            case POSITION_ACTINIDES:
                return getActinidesView(view, parent);
            default:
                if (element == null) {
                    return getEmptyView(view, parent);
                } else {
                    return getElementCardView(view, element, parent);
                }
        }
    }

    private View getElementCardView(View elementCardView, Element element, ViewGroup parent) {
        if (elementCardView == null) {
            elementCardView = LayoutInflater.from(getContext()).inflate(R.layout.layout_card_element, parent, false);
        }

        CardView cvElementCard = elementCardView.findViewById(R.id.cv_element_card);
        TextView tvName = elementCardView.findViewById(R.id.tv_name);
        TextView tvSymbol = elementCardView.findViewById(R.id.tv_symbol);
        TextView tvAtomicNumber = elementCardView.findViewById(R.id.tv_atomic_number);

        cvElementCard.setCardBackgroundColor(parent.getResources().getColor(getCardColor(element.getCategory())));
        tvName.setText(Element.elementStringIds[element.getAtomicNumber()-1]);
        tvSymbol.setText(element.getSymbol());
        tvAtomicNumber.setText(Integer.toString(element.getAtomicNumber()));

        elementCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.on_click));
                periodTableListener.onElementSelected(element);
            }
        });

        elementCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.on_long_click));
                Intent intent = new Intent(getContext(), ElementDataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(ElementDataActivity.ELEMENT_EXTRA, element.getAtomicNumber());
                intent.putExtras(bundle);
                getContext().startActivity(intent);
                return false;
            }
        });

        elementCardView.setEnabled(true);
        elementCardView.setClickable(true);
        elementCardView.setVisibility(View.VISIBLE);

        return elementCardView;
    }

    private View getEmptyView(View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_card_element, parent, false);
        }

        view.setEnabled(false);
        view.setClickable(false);
        view.setVisibility(View.GONE);
        return view;
    }

    private View getLanthanidesView(View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_card_element, parent, false);
        }

        CardView cvElementCard = view.findViewById(R.id.cv_element_card);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvSymbol = view.findViewById(R.id.tv_symbol);
        TextView tvAtomicNumber = view.findViewById(R.id.tv_atomic_number);

        cvElementCard.setCardBackgroundColor(parent.getResources().getColor(getCardColor(Element.CATEGORY_LANTHANIDES)));
        tvName.setText(getContext().getString(R.string.category_lanthanides));
        tvAtomicNumber.setText(getContext().getString(R.string.label_lanthanides_range));
        tvSymbol.setText("");
        view.setClickable(false);
        view.setVisibility(View.VISIBLE);

        return view;
    }

    private View getActinidesView(View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_card_element, parent, false);
        }

        CardView cvElementCard = view.findViewById(R.id.cv_element_card);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvSymbol = view.findViewById(R.id.tv_symbol);
        TextView tvAtomicNumber = view.findViewById(R.id.tv_atomic_number);

        cvElementCard.setCardBackgroundColor(parent.getResources().getColor(getCardColor(Element.CATEGORY_ACTINIDES)));
        tvName.setText(getContext().getString(R.string.category_actinides));
        tvAtomicNumber.setText(getContext().getString(R.string.label_actinides_range));
        tvSymbol.setText("");
        view.setEnabled(true);
        view.setClickable(false);
        view.setVisibility(View.VISIBLE);

        return view;
    }

    private View getPeriodView(View view, int position, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_card_period, parent, false);
        }

        TextView tvPeriod = view.findViewById(R.id.tv_period);
        tvPeriod.setText(Integer.toString(position / 19));
        view.setClickable(false);
        view.setVisibility(View.VISIBLE);

        return view;
    }

    private View getGroupView(View view, int position, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_card_group, parent, false);
        }

        TextView tvGroupNew = view.findViewById(R.id.tv_group_new);
        TextView tvGroupOld = view.findViewById(R.id.tv_group_old);

        switch (position) {
            case POSITION_GROUP_1:
                tvGroupNew.setText("1");
                tvGroupOld.setText("IA");
                break;
            case POSITION_GROUP_2:
                tvGroupNew.setText("2");
                tvGroupOld.setText("IIA");
                break;
            case POSITION_GROUP_3:
                tvGroupNew.setText("3");
                tvGroupOld.setText("IIIB");
                break;
            case POSITION_GROUP_4:
                tvGroupNew.setText("4");
                tvGroupOld.setText("IVB");
                break;
            case POSITION_GROUP_5:
                tvGroupNew.setText("5");
                tvGroupOld.setText("VB");
                break;
            case POSITION_GROUP_6:
                tvGroupNew.setText("6");
                tvGroupOld.setText("VIB");
                break;
            case POSITION_GROUP_7:
                tvGroupNew.setText("7");
                tvGroupOld.setText("VIIB");
                break;
            case POSITION_GROUP_8:
                tvGroupNew.setText("8");
                tvGroupOld.setText("VIIIB");
                break;
            case POSITION_GROUP_9:
                tvGroupNew.setText("9");
                tvGroupOld.setText("VIIIB");
                break;
            case POSITION_GROUP_10:
                tvGroupNew.setText("10");
                tvGroupOld.setText("VIIIB");
                break;
            case POSITION_GROUP_11:
                tvGroupNew.setText("11");
                tvGroupOld.setText("IB");
                break;
            case POSITION_GROUP_12:
                tvGroupNew.setText("12");
                tvGroupOld.setText("IIB");
                break;
            case POSITION_GROUP_13:
                tvGroupNew.setText("13");
                tvGroupOld.setText("IIIA");
                break;
            case POSITION_GROUP_14:
                tvGroupNew.setText("14");
                tvGroupOld.setText("IVA");
                break;
            case POSITION_GROUP_15:
                tvGroupNew.setText("15");
                tvGroupOld.setText("VA");
                break;
            case POSITION_GROUP_16:
                tvGroupNew.setText("16");
                tvGroupOld.setText("VIA");
                break;
            case POSITION_GROUP_17:
                tvGroupNew.setText("17");
                tvGroupOld.setText("VIIA");
                break;
            case POSITION_GROUP_18:
                tvGroupNew.setText("18");
                tvGroupOld.setText("VIIIA");
                break;
        }

        view.setClickable(false);
        view.setVisibility(View.VISIBLE);
        return view;
    }

    private int getCardColor(String category) {
        switch (category) {
            case Element.CATEGORY_NONMETALS:
                return settings.isNonMetalsChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_NONMETALS) : R.color.unselected;
            case Element.CATEGORY_ALKALI_METALS:
                return settings.isAlkaliMetalsCheck() ?
                        Element.categoryColor.get(Element.CATEGORY_ALKALI_METALS) : R.color.unselected;
            case Element.CATEGORY_ALKALINE_EARTH_METALS:
                return settings.isAlkalineEarthMetalsChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_ALKALINE_EARTH_METALS) : R.color.unselected;
            case Element.CATEGORY_TRANSITION_METALS:
                return settings.isTransitionMetalsChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_TRANSITION_METALS) : R.color.unselected;
            case Element.CATEGORY_POST_TRANSITION_METALS:
                return settings.isPostTransitionMetalsChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_POST_TRANSITION_METALS) : R.color.unselected;
            case Element.CATEGORY_METALLOIDS:
                return settings.isMetalloidsChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_METALLOIDS) : R.color.unselected;
            case Element.CATEGORY_LANTHANIDES:
                return settings.isLanthanidesChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_LANTHANIDES) : R.color.unselected;
            case Element.CATEGORY_ACTINIDES:
                return settings.isActinidesChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_ACTINIDES) : R.color.unselected;
            case Element.CATEGORY_HALOGENS:
                return settings.isHalogensChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_HALOGENS) : R.color.unselected;
            case Element.CATEGORY_NOBLE_GASES:
                return settings.isNobleGasesChecked() ?
                        Element.categoryColor.get(Element.CATEGORY_NOBLE_GASES) : R.color.unselected;
            default:
                return R.color.unselected;
        }
    }

    public interface ElementSelectedListener {
        void onElementSelected(Element selectedElement);
    }
}
