package com.fujitalabs.periodic_table;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import com.otaliastudios.zoom.ZoomLayout;

public class AppBarListener implements Toolbar.OnMenuItemClickListener {

    private Context context;
    private final String[] filterCategories = {"Nonmetals", "Alkali Metals", "Alkaline Earth Metals", "Transition Metals",
            "Post-Transition Metals", "Metalloids", "Lanthanides", "Actinides", "Halogens",  "Noble Gases"};
    private boolean[] filterCheckedItems = {true, true, true, true, true, true, true, true, true, true};
    private ZoomLayout zoomLayout;

    public AppBarListener(Context context, ZoomLayout zoomLayout) {
        this.context = context;
        this.zoomLayout = zoomLayout;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.appbar_search:
                Intent searchActivityIntent = new Intent(context, SearchActivity.class);
                context.startActivity(searchActivityIntent);
                break;
            case R.id.appbar_filter:
                onSetFilterCallback();
                break;
            case R.id.appbar_zoom_out:
                float zOut = zoomLayout.getZoom();
                zoomLayout.zoomTo(zOut - 1, true);
                break;
            case R.id.appbar_zoom_in:
                float zIn = zoomLayout.getZoom();
                zoomLayout.zoomTo(zIn + 1, true);
                break;
            case R.id.appbar_fit_screen:
                zoomLayout.zoomTo(1.0f, true);
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
