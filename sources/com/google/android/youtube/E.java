package com.google.android.youtube;

import defpackage.U;
import defpackage.fM;
import defpackage.gl;

/* JADX INFO: loaded from: classes.dex */
final class E implements defpackage.I {
    private /* synthetic */ D a;

    E(D d) {
        this.a = d;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        this.a.a.A.a(gl.GDATA_ERROR);
        C0081l.a("Error loading video [request=" + ((U) obj) + "]", exc);
        D.a(this.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        D.a(this.a, (fM) obj2);
    }
}
