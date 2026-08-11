package com.google.android.youtube;

import defpackage.C0200fv;
import defpackage.U;

/* JADX INFO: loaded from: classes.dex */
final class G implements defpackage.I {
    private /* synthetic */ D a;

    G(D d) {
        this.a = d;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error loading playlist page [request=" + ((U) obj) + "]", exc);
        D.a(this.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        D.a(this.a, (C0200fv) obj2);
    }
}
