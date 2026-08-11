package com.google.android.youtube.ui;

import android.graphics.Bitmap;
import com.google.android.youtube.C0081l;

/* JADX INFO: renamed from: com.google.android.youtube.ui.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0091d implements defpackage.I {
    private /* synthetic */ C0090c a;

    /* synthetic */ C0091d(C0090c c0090c) {
        this(c0090c, (byte) 0);
    }

    private C0091d(C0090c c0090c, byte b) {
        this.a = c0090c;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error retrieving user thumbnail", exc);
        C0093f.b(this.a.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.a.e.setImageBitmap((Bitmap) obj2);
    }
}
