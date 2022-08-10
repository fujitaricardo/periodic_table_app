package com.fujitalabs.periodic_table;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

    private int selectedTheme;
    private int selectedLanguage;
    private int selectedScreenRotation;
    private boolean[] selectedCategories;

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

        mtAppBar.setOnMenuItemClickListener(new AppbarListener());
        mtAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlMainActivity.openDrawer(Gravity.LEFT);
            }
        });

        nvMenu.setNavigationItemSelectedListener(new MenuListener());

        periodicTableGVAdapter = new PeriodicTableGVAdapter(this, settings.getChemicalElements(), new PeriodicTableListener());
        gvPeriodicTable.setAdapter(periodicTableGVAdapter);
    }

    private class AppbarListener implements Toolbar.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.appbar_search:
                    break;
                case R.id.appbar_filter:
                    onSetFilterCallback();
                    break;
                case R.id.appbar_rotate:
                    break;
            }
            return false;
        }

        private void onSetFilterCallback() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Select categories:");
            String[] elementCategories = {"Nonmetals", "Alkali Metals", "Alkaline Earth Metals", "Transition Metals",
                    "Post-Transition Metals", "Metalloids", "Lanthanides", "Actinides", "Halogens",  "Noble Gases"};
            boolean[] checkedItems = {true, true, true, true, true, true, true, true, true, true};

            builder.setMultiChoiceItems(elementCategories, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    checkedItems[which] = isChecked;
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    private class MenuListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_search:
                    break;
                case R.id.menu_rotation:
                    onSetScreenRotationCallback();
                    break;
                case R.id.menu_theme:
                    onSetThemeCallback();
                    break;
                case R.id.menu_language:
                    onSetLanguageCallback();
                    break;
                case R.id.menu_feedback:
                    break;
                case R.id.menu_privacy_policy:
                    break;
                case R.id.menu_about:
                    break;
            }
            return true;
        }

        private void onSetScreenRotationCallback() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Set screen rotation:");
            builder.setSingleChoiceItems(settings.menuRotationOptions, selectedScreenRotation, new DialogInterface.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedScreenRotation = which;
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog customAlertDialog = builder.create();
            customAlertDialog.show();
        }

        private void onSetThemeCallback() {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Set theme:");

            alertDialog.setSingleChoiceItems(settings.menuThemeOptions, selectedTheme, new DialogInterface.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedTheme = which;
                }
            });
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog customAlertDialog = alertDialog.create();
            customAlertDialog.show();
        }

        private void onSetLanguageCallback() {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Set language:");

            alertDialog.setSingleChoiceItems(settings.menuLanguageOptions, selectedLanguage, new DialogInterface.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedLanguage = which;
                }
            });

            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog customAlertDialog = alertDialog.create();
            customAlertDialog.show();
        }
    }

    private class PeriodicTableListener implements PeriodicTableGVAdapter.ElementSelectedListener {
        @Override
        public void onElementSelected(ChemicalElement chemicalElement) {
            TextView name = bsElementSheet.findViewById(R.id.tv_name);
            TextView symbol = bsElementSheet.findViewById(R.id.tv_symbol);
            TextView atomicNumber = bsElementSheet.findViewById(R.id.tv_atomic_number);
            TextView atomicWeight = bsElementSheet.findViewById(R.id.tv_atomic_weight);
            TextView seeMore = bsElementSheet.findViewById(R.id.tv_see_more);

            name.setText(chemicalElement.getName());
            symbol.setText(chemicalElement.getSymbol());
            atomicNumber.setText(Integer.toString(chemicalElement.getAtomicNumber()));

            if (chemicalElement.getAtomicWeight() == -1) {
                atomicWeight.setText("unknown");
            } else {
                atomicWeight.setText(Float.toString(chemicalElement.getAtomicWeight()));
            }

            seeMore.setText("SEE MORE");
            seeMore.setClickable(true);
            seeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getBaseContext(), "Clicked on see more!", Toast.LENGTH_SHORT).show();
                }
            });

            bsElementSheet.setVisibility(View.VISIBLE);
            bsElementSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }
}
