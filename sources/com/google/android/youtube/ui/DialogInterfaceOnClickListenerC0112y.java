package com.google.android.youtube.ui;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.google.android.youtube.ui.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0112y implements DialogInterface.OnClickListener {
    private /* synthetic */ ViewOnClickListenerC0111x a;

    DialogInterfaceOnClickListenerC0112y(ViewOnClickListenerC0111x viewOnClickListenerC0111x) {
        this.a = viewOnClickListenerC0111x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.d.hide();
        this.a.a(defpackage.X.values()[i]);
    }
}
