package com.fujitalabs.periodic_table;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.navigation.NavigationView;

public class MenuListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;
    private Settings settings;

    private int selectedTheme;
    private int selectedLanguage;

    public MenuListener(Context context) {
        this.context = context;
        settings = Settings.getInstance(context);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Intent searchActivityIntent = new Intent(context, SearchActivity.class);
                context.startActivity(searchActivityIntent);
                break;
            case R.id.menu_theme:
                onSetThemeCallback();
                break;
            case R.id.menu_language:
                onSetLanguageCallback();
                break;
            case R.id.menu_feedback:
                Intent feedbackActivityIntent = new Intent(context, FeedbackActivity.class);
                context.startActivity(feedbackActivityIntent);
                break;
            case R.id.menu_privacy_policy:
                Intent privacyPolicyActivityIntent = new Intent(context, PrivacyPolicyActivity.class);
                context.startActivity(privacyPolicyActivityIntent);
                break;
            case R.id.menu_about:
                Intent aboutActivityIntent = new Intent(context, AboutActivity.class);
                context.startActivity(aboutActivityIntent);
                break;
        }
        return true;
    }

    private void onSetThemeCallback() {
        selectedTheme = settings.isDarkMode() ? 1 : 0;
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
                boolean isDarkMode = selectedTheme == 1;
                settings.setDarkMode(isDarkMode);

                if (isDarkMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                dialog.dismiss();
            }
        });

        AlertDialog customAlertDialog = alertDialog.create();
        customAlertDialog.show();
    }

    private void onSetLanguageCallback() {
        selectedLanguage = settings.getSelectedLanguage();
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
                settings.setSelectedLanguage(selectedLanguage);
                dialog.dismiss();
            }
        });

        AlertDialog customAlertDialog = alertDialog.create();
        customAlertDialog.show();
    }
}
