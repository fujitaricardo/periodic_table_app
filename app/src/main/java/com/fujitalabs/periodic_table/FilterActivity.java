package com.fujitalabs.periodic_table;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class FilterActivity extends AppCompatActivity {

    private Settings settings;
    private MaterialToolbar mtAppBar;
    private CheckBox cbNonMetals;
    private CheckBox cbAlkaliMetals;
    private CheckBox cbAlkalineEarthMetals;
    private CheckBox cbTransitionMetals;
    private CheckBox cbPostTransitionMetals;
    private CheckBox cbMetalloids;
    private CheckBox cbLanthanides;
    private CheckBox cbActinides;
    private CheckBox cbHalogens;
    private CheckBox cbNobleGases;
    private TextView tvSelectAll;
    private TextView tvRemoveAll;
    private TextView tvSave;
    private TextView tvCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = MainActivity.getSettings();
        setViews();
    }

    private void setViews() {
        setContentView(R.layout.activity_filter);

        mtAppBar = findViewById(R.id.mt_app_bar);
        mtAppBar.setTitle("Filter");
        mtAppBar.setTitleCentered(true);
        mtAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cbNonMetals = findViewById(R.id.cb_non_metals);
        cbAlkaliMetals = findViewById(R.id.cb_alkali_metals);
        cbAlkalineEarthMetals = findViewById(R.id.cb_alkaline_earth_metals);
        cbTransitionMetals = findViewById(R.id.cb_transition_metals);
        cbPostTransitionMetals = findViewById(R.id.cb_post_transition_metals);
        cbMetalloids = findViewById(R.id.cb_metalloids);
        cbLanthanides = findViewById(R.id.cb_lanthanides);
        cbActinides = findViewById(R.id.cb_actinides);
        cbHalogens = findViewById(R.id.cb_halogens);
        cbNobleGases = findViewById(R.id.cb_noble_gases);
        tvSelectAll = findViewById(R.id.tv_select_all);
        tvRemoveAll = findViewById(R.id.tv_remove_all);
        tvSave = findViewById(R.id.tv_save);
        tvCancel = findViewById(R.id.tv_cancel);

        cbNonMetals.setChecked(settings.isNonMetalsChecked());
        cbAlkaliMetals.setChecked(settings.isAlkaliMetalsCheck());
        cbAlkalineEarthMetals.setChecked(settings.isAlkalineEarthMetalsChecked());
        cbTransitionMetals.setChecked(settings.isTransitionMetalsChecked());
        cbPostTransitionMetals.setChecked(settings.isPostTransitionMetalsChecked());
        cbMetalloids.setChecked(settings.isMetalloidsChecked());
        cbLanthanides.setChecked(settings.isLanthanidesChecked());
        cbActinides.setChecked(settings.isActinidesChecked());
        cbHalogens.setChecked(settings.isHalogensChecked());
        cbNobleGases.setChecked(settings.isNobleGasesChecked());

        tvSelectAll.setClickable(true);
        tvSelectAll.setEnabled(true);
        tvSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAll(true);
            }
        });

        tvRemoveAll.setClickable(true);
        tvRemoveAll.setEnabled(true);
        tvRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAll(false);
            }
        });

        tvCancel.setClickable(true);
        tvCancel.setEnabled(true);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvSave.setClickable(true);
        tvSave.setEnabled(true);
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFilter();
                onBackPressed();
            }
        });
    }

    private void setAll(boolean isChecked) {
        cbNonMetals.setChecked(isChecked);
        cbAlkaliMetals.setChecked(isChecked);
        cbAlkalineEarthMetals.setChecked(isChecked);
        cbTransitionMetals.setChecked(isChecked);
        cbPostTransitionMetals.setChecked(isChecked);
        cbMetalloids.setChecked(isChecked);
        cbLanthanides.setChecked(isChecked);
        cbActinides.setChecked(isChecked);
        cbHalogens.setChecked(isChecked);
        cbNobleGases.setChecked(isChecked);
    }

    private void saveFilter() {
        settings.setNonMetalsChecked(cbNonMetals.isChecked());
        settings.setAlkaliMetalsCheck(cbAlkaliMetals.isChecked());
        settings.setAlkalineEarthMetalsChecked(cbAlkalineEarthMetals.isChecked());
        settings.setTransitionMetalsChecked(cbTransitionMetals.isChecked());
        settings.setPostTransitionMetalsChecked(cbPostTransitionMetals.isChecked());
        settings.setMetalloidsChecked(cbMetalloids.isChecked());
        settings.setLanthanidesChecked(cbLanthanides.isChecked());
        settings.setActinidesChecked(cbActinides.isChecked());
        settings.setHalogensChecked(cbHalogens.isChecked());
        settings.setNobleGasesChecked(cbNobleGases.isChecked());
    }
}
