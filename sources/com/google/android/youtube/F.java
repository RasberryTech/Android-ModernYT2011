package com.google.android.youtube;

import defpackage.fK;

/* JADX INFO: loaded from: classes.dex */
final class F implements defpackage.I {
    private /* synthetic */ D a;

    F(D d) {
        this.a = d;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        String str = (String) obj;
        C0081l.a("Error loading ad [request=" + str + "]", exc);
        this.a.a(str, (fK) null);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.a.a((String) obj, (fK) obj2);
    }
}
