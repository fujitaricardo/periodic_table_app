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
    private TextView tvClearFilters;
    private TextView tvApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = MainActivity.getSettings();
        setViews();
    }

    private void setViews() {
        setContentView(R.layout.activity_filter);

        mtAppBar = findViewById(R.id.mt_app_bar);
        mtAppBar.setTitle("Select Filters");
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
        tvClearFilters = findViewById(R.id.tv_clear_filters);
        tvApply = findViewById(R.id.tv_apply);

        tvClearFilters.setClickable(true);
        tvClearFilters.setEnabled(true);
        tvClearFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setFilterOn(false);
                clearAllFilters();
                onBackPressed();
            }
        });

        tvApply.setClickable(true);
        tvApply.setEnabled(true);
        tvApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnyFilterSelected()) {
                    settings.setFilterOn(true);
                    applyFilters();
                } else {
                    settings.setFilterOn(false);
                    clearAllFilters();
                }
                onBackPressed();
            }
        });

        if (settings.isFilterOn()) {
            setFilters();
        }
    }

    private void setFilters() {
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
    }

    private void applyFilters() {
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

    private void clearAllFilters() {
        settings.setNonMetalsChecked(true);
        settings.setAlkaliMetalsCheck(true);
        settings.setAlkalineEarthMetalsChecked(true);
        settings.setTransitionMetalsChecked(true);
        settings.setPostTransitionMetalsChecked(true);
        settings.setMetalloidsChecked(true);
        settings.setLanthanidesChecked(true);
        settings.setActinidesChecked(true);
        settings.setHalogensChecked(true);
        settings.setNobleGasesChecked(true);
    }

    private boolean isAnyFilterSelected() {
        return cbNonMetals.isChecked() || cbAlkaliMetals.isChecked() || cbAlkalineEarthMetals.isChecked()
                || cbTransitionMetals.isChecked() || cbPostTransitionMetals.isChecked() || cbMetalloids.isChecked()
                || cbLanthanides.isChecked() || cbActinides.isChecked() || cbHalogens.isChecked() || cbNobleGases.isChecked();
    }
}
