package com.google.android.youtube.ui;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
final class I implements defpackage.I {
    private /* synthetic */ G a;

    /* synthetic */ I(G g) {
        this(g, (byte) 0);
    }

    private I(G g, byte b) {
        this.a = g;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        this.a.c.a((Uri) obj, null);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.a.c.a((Uri) obj, (Bitmap) obj2);
    }
}
