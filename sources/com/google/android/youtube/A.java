package com.google.android.youtube;

import android.content.DialogInterface;
import defpackage.gt;

/* JADX INFO: loaded from: classes.dex */
final class A implements DialogInterface.OnClickListener {
    private /* synthetic */ SettingsActivity a;

    A(SettingsActivity settingsActivity) {
        this.a = settingsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.i().a(gt.values()[i]);
        dialogInterface.dismiss();
    }
}
