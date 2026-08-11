package com.google.android.youtube.ui;

import android.database.DataSetObserver;

/* JADX INFO: renamed from: com.google.android.youtube.ui.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0097j extends DataSetObserver {
    private /* synthetic */ C0096i a;

    /* synthetic */ C0097j(C0096i c0096i) {
        this(c0096i, (byte) 0);
    }

    private C0097j(C0096i c0096i, byte b) {
        this.a = c0096i;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.a.notifyDataSetChanged();
    }
}
