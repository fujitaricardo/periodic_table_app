package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

public class AppBarListener implements Toolbar.OnMenuItemClickListener {

    private Context context;
    private final String[] filterCategories = {"Nonmetals", "Alkali Metals", "Alkaline Earth Metals", "Transition Metals",
            "Post-Transition Metals", "Metalloids", "Lanthanides", "Actinides", "Halogens",  "Noble Gases"};
    private boolean[] filterCheckedItems = {true, true, true, true, true, true, true, true, true, true};

    public AppBarListener(Context context) {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.appbar_search:
                Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appbar_filter:
                onSetFilterCallback();
                break;
            case R.id.appbar_rotate:
                Toast.makeText(context, "Screen rotation", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    private void onSetFilterCallback() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select categories:");

        builder.setMultiChoiceItems(filterCategories, filterCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                filterCheckedItems[which] = isChecked;
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
