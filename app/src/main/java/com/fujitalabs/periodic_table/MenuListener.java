package com.fujitalabs.periodic_table;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.navigation.NavigationView;

public class MenuListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;
    private Settings settings;

    private int selectedTheme;
    private int selectedLanguage;
    private int selectedScreenRotation;

    public MenuListener(Context context) {
        this.context = context;
        settings = Settings.getInstance();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(context, "Feedback", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_privacy_policy:
                Toast.makeText(context, "Privacy policy", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_about:
                Toast.makeText(context, "About", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void onSetScreenRotationCallback() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
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
