package com.google.android.youtube;

import defpackage.V;
import defpackage.fK;

/* JADX INFO: renamed from: com.google.android.youtube.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0071b implements defpackage.I {
    private final String a;
    private /* synthetic */ C0070a b;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error retrieving VAST ad", exc);
        this.b.e.a((Object) this.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        fK fKVar = (fK) obj2;
        if (fKVar == null) {
            this.b.e.a(this.a, (Object) null);
        } else if (C0070a.a(fKVar.b)) {
            this.b.d.a(V.b(fKVar.b.getQueryParameter("v")), new C0072c(this.b, this.a, fKVar));
        } else {
            this.b.e.a(this.a, fKVar);
        }
    }

    public C0071b(C0070a c0070a, String str) {
        this.b = c0070a;
        this.a = str;
    }
}
