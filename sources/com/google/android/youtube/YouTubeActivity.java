package com.google.android.youtube;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.ui.ViewOnClickListenerC0098k;
import defpackage.C0210ge;
import defpackage.gp;

/* JADX INFO: loaded from: classes.dex */
public abstract class YouTubeActivity extends Activity {
    private YouTubeApplication a;
    private final int b = C0210ge.a(getClass().getSimpleName());
    private SharedPreferences c;
    private ViewOnClickListenerC0098k d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setDefaultKeyMode(3);
        setVolumeControlStream(3);
        this.a = (YouTubeApplication) getApplication();
        a(this.a);
        this.c = getSharedPreferences("youtube", 0);
        if (!this.a.a()) {
            showDialog(9);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        if (this.d == null) {
            this.d = new ViewOnClickListenerC0098k(this);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        if (this.d == null) {
            this.d = new ViewOnClickListenerC0098k(this);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        if (this.d == null) {
            this.d = new ViewOnClickListenerC0098k(this);
        }
    }

    protected void a(YouTubeApplication youTubeApplication) {
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, R.string.menu_home).setIcon(R.drawable.ic_menu_home);
        menu.add(0, 2, 0, R.string.menu_browse).setIcon(R.drawable.ic_menu_browse);
        menu.add(0, 7, 0, R.string.menu_search).setIcon(android.R.drawable.ic_menu_search);
        menu.add(0, 3, 0, R.string.menu_my_channel).setIcon(R.drawable.ic_menu_my_channel);
        if (gp.a((Context) this)) {
            menu.add(0, 8, 0, R.string.menu_upload).setIcon(android.R.drawable.ic_menu_upload_you_tube);
        }
        menu.add(0, 6, 0, R.string.menu_settings).setIcon(android.R.drawable.ic_menu_preferences);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case YouTubePlayer.PREPARED /* 1 */:
                if (!(this instanceof HomeActivity)) {
                    startActivity(HomeActivity.a((Context) this));
                }
                return true;
            case YouTubePlayer.PLAYING /* 2 */:
                if (!(this instanceof CategoriesActivity)) {
                    startActivity(new Intent(this, (Class<?>) CategoriesActivity.class).setFlags(67108864));
                }
                return true;
            case YouTubePlayer.PAUSED /* 3 */:
                if (!(this instanceof MyChannelActivity)) {
                    startActivity(new Intent(this, (Class<?>) MyChannelActivity.class).setFlags(67108864));
                }
                return true;
            case YouTubePlayer.STOPPED /* 4 */:
            case YouTubePlayer.PROGRESS /* 5 */:
            default:
                return false;
            case YouTubePlayer.ENDED /* 6 */:
                startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
                return true;
            case YouTubePlayer.ERROR /* 7 */:
                onSearchRequested();
                return true;
            case 8:
                gp.a((Activity) this);
                return true;
        }
    }

    protected final ViewOnClickListenerC0098k c() {
        return this.d;
    }

    @Override // android.app.Activity
    protected final Dialog onCreateDialog(int i) {
        return onCreateDialog(i, null);
    }

    @Override // android.app.Activity
    protected final Dialog onCreateDialog(int i, Bundle bundle) {
        if (isFinishing()) {
            return null;
        }
        switch (i) {
            case 9:
                AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R.string.startup_tos_title).setView(getLayoutInflater().inflate(R.layout.tos_dialog, (ViewGroup) null, false)).setPositiveButton(getString(R.string.accept), new M(this)).setNegativeButton(getString(R.string.decline), new L(this)).setOnCancelListener(new K(this)).create();
                alertDialogCreate.setOnKeyListener(new N(this));
                return alertDialogCreate;
            default:
                if (bundle != null) {
                    return null;
                }
                return a(i);
        }
    }

    protected Dialog a(int i) {
        return null;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        gp.a(this, i, i2, intent, this.c.getString("user_account", null));
    }

    public final void b(String str) {
        this.a.f().a(this.b, C0210ge.a(str));
    }
}
