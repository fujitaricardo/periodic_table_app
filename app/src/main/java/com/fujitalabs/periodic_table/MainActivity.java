package com.fujitalabs.periodic_table;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Settings settings;

    private GridView gvPeriodicTable;
    private LinearLayout bsElementSheet;
    private NavigationView nvMenu;
    private DrawerLayout dlMainActivity;
    private MaterialToolbar mtAppBar;
    private BottomSheetBehavior bsElementSheetBehavior;
    private PeriodicTableGVAdapter periodicTableGVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.settings = Settings.getInstance();
        setViews();
    }

    private void setViews() {
        setContentView(R.layout.activity_main);
        gvPeriodicTable = findViewById(R.id.gv_periodic_table);
        mtAppBar = findViewById(R.id.mt_app_bar);
        dlMainActivity = findViewById(R.id.dl_main_activity);
        bsElementSheet = findViewById(R.id.ll_bottom_sheet);
        nvMenu = findViewById(R.id.nv_menu);

        bsElementSheetBehavior = BottomSheetBehavior.from(bsElementSheet);
        bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mtAppBar.setOnMenuItemClickListener(new AppBarListener(this));
        mtAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlMainActivity.openDrawer(Gravity.LEFT);
            }
        });

        nvMenu.setNavigationItemSelectedListener(new MenuListener(this));

        periodicTableGVAdapter = new PeriodicTableGVAdapter(this, settings.getChemicalElements(),
                new PeriodicTableListener(this, bsElementSheet, bsElementSheetBehavior));
        gvPeriodicTable.setAdapter(periodicTableGVAdapter);
    }
}
