package com.google.android.youtube.ui;

import android.content.DialogInterface;
import defpackage.fG;

/* JADX INFO: renamed from: com.google.android.youtube.ui.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0109v implements DialogInterface.OnClickListener {
    private /* synthetic */ C0106s a;

    DialogInterfaceOnClickListenerC0109v(C0106s c0106s) {
        this.a = c0106s;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.i = null;
            this.a.c.setSubtitle(null);
            this.a.d.setCC(false);
        } else {
            fG fGVar = (fG) this.a.h.getItem(i);
            this.a.i = fGVar.a;
            String str = "requesting subtitle " + fGVar;
            this.a.f.a(fGVar, this.a.g);
        }
        this.a.b.edit().putString("subtitles_language_code", this.a.i).commit();
        dialogInterface.dismiss();
    }
}
