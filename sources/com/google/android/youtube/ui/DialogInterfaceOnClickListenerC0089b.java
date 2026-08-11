package com.google.android.youtube.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.google.android.youtube.WatchActivity;
import com.google.android.youtube.player.YouTubePlayer;
import defpackage.C0013am;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0021au;
import defpackage.fH;
import defpackage.fJ;
import defpackage.gq;

/* JADX INFO: renamed from: com.google.android.youtube.ui.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0089b implements defpackage.I, DialogInterface.OnClickListener, InterfaceC0021au {
    private final WatchActivity a;
    private final SharedPreferences b;
    private final C0013am c;
    private final InterfaceC0004ad d;
    private fJ e;
    private Dialog f;
    private Dialog g;
    private Dialog h;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0093f.b(this.a, exc);
        this.a.finish();
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        fJ fJVar = (fJ) obj2;
        this.e = fJVar;
        if (!(fJVar.b >= 18)) {
            this.a.showDialog(5);
            return;
        }
        if (this.b.getString("adult_content_confirmations", "").contains(fJVar.a)) {
            this.a.b();
        } else {
            this.a.showDialog(4);
        }
    }

    public DialogInterfaceOnClickListenerC0089b(WatchActivity watchActivity, SharedPreferences sharedPreferences, C0013am c0013am, InterfaceC0004ad interfaceC0004ad) {
        this.a = (WatchActivity) gq.a(watchActivity);
        this.b = (SharedPreferences) gq.a(sharedPreferences);
        this.c = (C0013am) gq.a(c0013am);
        this.d = (InterfaceC0004ad) gq.a(interfaceC0004ad);
    }

    public final void b() {
        this.e = null;
        if (this.c.b()) {
            this.c.a(this.a, this);
        } else {
            this.a.showDialog(3);
        }
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.d.a(defpackage.V.c(fHVar.c), new defpackage.E(this.a, this));
    }

    @Override // defpackage.InterfaceC0021au
    public final void a() {
        this.a.finish();
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(Exception exc) {
        C0093f.b(this.a, exc);
        this.a.finish();
    }

    public final Dialog a(int i) {
        switch (i) {
            case YouTubePlayer.PAUSED /* 3 */:
                this.f = new AlertDialog.Builder(this.a).setTitle(com.google.android.youtube.R.string.application_name).setMessage(this.a.getString(com.google.android.youtube.R.string.adult_content_intro) + this.a.getString(com.google.android.youtube.R.string.adult_content_login)).setPositiveButton(com.google.android.youtube.R.string.ok, this).setNegativeButton(com.google.android.youtube.R.string.cancel, this).create();
                return this.f;
            case YouTubePlayer.STOPPED /* 4 */:
                this.h = new AlertDialog.Builder(this.a).setTitle(com.google.android.youtube.R.string.application_name).setMessage(this.a.getString(com.google.android.youtube.R.string.adult_content_intro) + this.a.getString(com.google.android.youtube.R.string.adult_content_confirm)).setPositiveButton(com.google.android.youtube.R.string.confirm, this).setNegativeButton(com.google.android.youtube.R.string.cancel, this).create();
                return this.h;
            case YouTubePlayer.PROGRESS /* 5 */:
                this.g = new AlertDialog.Builder(this.a).setTitle(com.google.android.youtube.R.string.application_name).setMessage(this.a.getString(com.google.android.youtube.R.string.adult_content_underage)).setNegativeButton(com.google.android.youtube.R.string.ok, this).create();
                return this.g;
            default:
                return null;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -2:
                this.a.finish();
                break;
            case -1:
                if (dialogInterface == this.f) {
                    this.c.a(this.a, this);
                } else if (dialogInterface == this.h) {
                    this.b.edit().putString("adult_content_confirmations", this.b.getString("adult_content_confirmations", "") + "," + this.e.a).commit();
                    this.a.b();
                }
                break;
        }
    }
}
