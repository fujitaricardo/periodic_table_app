package com.fujitalabs.periodic_table;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.otaliastudios.zoom.ZoomLayout;

public class MainActivity extends AppCompatActivity {

    private static Settings settings;

    private GridView gvPeriodicTable;
    private LinearLayout bsElementSheet;
    private NavigationView nvMenu;
    private DrawerLayout dlMainActivity;
    private MaterialToolbar mtAppBar;
    private BottomSheetBehavior bsElementSheetBehavior;
    private PeriodicTableGVAdapter periodicTableGVAdapter;
    private ZoomLayout zlPeriodicTableZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.settings = Settings.getInstance(this);
        setViews();
        setDarkMode();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        gvPeriodicTable.invalidateViews();
    }

    private void setViews() {
        setContentView(R.layout.activity_main);
        gvPeriodicTable = findViewById(R.id.gv_periodic_table);
        mtAppBar = findViewById(R.id.mt_app_bar);
        dlMainActivity = findViewById(R.id.dl_main_activity);
        bsElementSheet = findViewById(R.id.ll_bottom_sheet);
        nvMenu = findViewById(R.id.nv_menu);
        zlPeriodicTableZoom = findViewById(R.id.zl_periodic_table_zoom);

        bsElementSheetBehavior = BottomSheetBehavior.from(bsElementSheet);
        bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mtAppBar.setOnMenuItemClickListener(new AppBarListener(this, zlPeriodicTableZoom));
        mtAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlMainActivity.openDrawer(Gravity.LEFT);
                bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        nvMenu.setNavigationItemSelectedListener(new MenuListener(this));

        periodicTableGVAdapter = new PeriodicTableGVAdapter(this, settings.getChemicalElements(),
                new PeriodicTableListener(this, bsElementSheet, bsElementSheetBehavior));
        gvPeriodicTable.setAdapter(periodicTableGVAdapter);
    }

    private void setDarkMode() {
        if (settings.isDarkMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public static Settings getSettings() {
        return settings;
    }
}
