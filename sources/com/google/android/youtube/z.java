package com.google.android.youtube;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
final class z implements DialogInterface.OnClickListener {
    private /* synthetic */ SettingsActivity a;

    z(SettingsActivity settingsActivity) {
        this.a = settingsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.h();
    }
}
