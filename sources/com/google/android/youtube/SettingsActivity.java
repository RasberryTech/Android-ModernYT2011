package com.google.android.youtube;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import com.google.android.youtube.player.YouTubePlayer;
import defpackage.gp;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class SettingsActivity extends PreferenceActivity {
    private YouTubeApplication a;
    private SharedPreferences b;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.youtube_preferences);
        getPreferenceManager().setSharedPreferencesName("youtube");
        this.a = (YouTubeApplication) getApplication();
        this.b = getSharedPreferences("youtube", 0);
        findPreference("version").setSummary(this.a.c());
        ((CheckBoxPreference) findPreference("default_hq")).setChecked(this.b.getBoolean("default_hq", false));
        findPreference("safe_search").setEnabled(!this.a.i().b());
        String string = this.b.getString("subtitles_size", null);
        if (string != null) {
            ListPreference listPreference = (ListPreference) findPreference("subtitles_size");
            int iBinarySearch = Arrays.binarySearch(listPreference.getEntryValues(), string);
            if (iBinarySearch >= 0) {
                listPreference.setValueIndex(iBinarySearch);
            }
        }
    }

    @Override // android.preference.PreferenceActivity
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        String key = preference.getKey();
        if ("clear_history".equals(key)) {
            showDialog(7);
            return true;
        }
        if ("safe_search".equals(key)) {
            showDialog(8);
            return true;
        }
        if ("default_hq".equals(key)) {
            this.b.edit().putBoolean("default_hq", ((CheckBoxPreference) preference).isChecked()).commit();
            return true;
        }
        if ("mobile_terms".equals(key)) {
            gp.a(this, Uri.parse(getString(R.string.uri_mobile_terms)));
        } else if ("youtube_terms".equals(key)) {
            gp.a(this, Uri.parse(getString(R.string.uri_youtube_terms)));
        } else if ("mobile_privacy".equals(key)) {
            gp.a(this, Uri.parse(getString(R.string.uri_mobile_privacy)));
        } else if ("youtube_privacy".equals(key)) {
            gp.a(this, Uri.parse(getString(R.string.uri_youtube_privacy)));
        } else if ("feedback".equals(key)) {
            gp.a(this, Uri.parse(a(R.string.uri_feedback)));
        } else if ("help".equals(key)) {
            gp.a(this, Uri.parse(a(R.string.uri_help)));
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private String a(int i) {
        Locale locale = Locale.getDefault();
        return getResources().getString(i, locale.getLanguage(), locale.getCountry().toLowerCase());
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case YouTubePlayer.ERROR /* 7 */:
                return new AlertDialog.Builder(this).setTitle(R.string.confirm_clear_search_title).setIcon(android.R.drawable.ic_dialog_alert).setMessage(R.string.confirm_clear_search_text).setPositiveButton(android.R.string.ok, new z(this)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).create();
            case 8:
                return new AlertDialog.Builder(this).setTitle(R.string.safe_search_dialog_title).setSingleChoiceItems(R.array.safe_search_levels, this.a.i().a().ordinal(), new A(this)).create();
            default:
                return super.onCreateDialog(i);
        }
    }
}
