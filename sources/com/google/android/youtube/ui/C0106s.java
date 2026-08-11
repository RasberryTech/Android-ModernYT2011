package com.google.android.youtube.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.player.ControllerOverlay;
import com.google.android.youtube.player.SubtitleOverlay;
import defpackage.InterfaceC0004ad;
import defpackage.fD;
import defpackage.fM;
import defpackage.gq;

/* JADX INFO: renamed from: com.google.android.youtube.ui.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0106s implements defpackage.I {
    private final Activity a;
    private final SharedPreferences b;
    private final SubtitleOverlay c;
    private final ControllerOverlay d;
    private final InterfaceC0004ad e;
    private final InterfaceC0004ad f;
    private final defpackage.E g;
    private ArrayAdapter h;
    private String i;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("error retrieving subtitle", exc);
        b();
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.c.setSubtitle((fD) obj2);
        this.d.setCC(true);
    }

    public C0106s(Activity activity, SharedPreferences sharedPreferences, SubtitleOverlay subtitleOverlay, ControllerOverlay controllerOverlay, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2) {
        this.a = (Activity) gq.a(activity);
        this.b = (SharedPreferences) gq.a(sharedPreferences);
        this.e = (InterfaceC0004ad) gq.a(interfaceC0004ad);
        this.f = (InterfaceC0004ad) gq.a(interfaceC0004ad2);
        this.c = (SubtitleOverlay) gq.a(subtitleOverlay);
        this.d = (ControllerOverlay) gq.a(controllerOverlay);
        this.g = new defpackage.E(activity, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.c.setSubtitle(null);
        this.d.showCC(false);
        this.d.setCC(false);
    }

    public final void a(fM fMVar) {
        gq.a(fMVar);
        b();
        if (fMVar.h != null) {
            this.d.showCC(true);
            this.c.setTextSize(Float.parseFloat(this.b.getString("subtitles_size", "16")));
            this.i = this.b.getString("subtitles_language_code", null);
            if (this.i != null) {
                String str = "initializing to " + this.i;
                this.e.a(fMVar.a, new C0107t(this));
            }
        }
    }

    public final void a(String str) {
        gq.a((Object) str);
        this.i = null;
        this.e.a(str, new defpackage.E(this.a, new C0108u(this)));
    }

    public final Dialog a() {
        return new AlertDialog.Builder(this.a).setTitle(com.google.android.youtube.R.string.subtitles).setSingleChoiceItems(this.h, 0, new DialogInterfaceOnClickListenerC0109v(this)).create();
    }
}
