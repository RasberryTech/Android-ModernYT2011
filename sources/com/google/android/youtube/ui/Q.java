package com.google.android.youtube.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.youtube.C0081l;
import defpackage.C0190fl;

/* JADX INFO: loaded from: classes.dex */
final class Q implements defpackage.I {
    final /* synthetic */ C0190fl a;
    final /* synthetic */ P b;

    Q(P p, C0190fl c0190fl) {
        this.b = p;
        this.a = c0190fl;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Couldn't retrieve branding image from [uri=" + ((Uri) obj) + "]", exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.b.g.setVisibility(0);
        this.b.g.setImageBitmap((Bitmap) obj2);
        this.b.g.setOnClickListener(new R(this));
    }
}
