package com.google.android.youtube.ui;

import com.google.android.youtube.C0081l;
import defpackage.C0188fj;

/* JADX INFO: loaded from: classes.dex */
final class V implements defpackage.I {
    private /* synthetic */ S a;

    V(S s) {
        this.a = s;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.b("failed to get disco results for artist " + ((String) obj) + " : " + exc);
        String strA = C0093f.a(this.a.a, exc);
        this.a.l.b(strA, true);
        this.a.i.b(strA, true);
        this.a.n.a(strA, true);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        C0188fj c0188fj = (C0188fj) obj2;
        if (this.a.o == null || !c0188fj.a.a.equals(this.a.o.b)) {
            C0081l.b("got stale result for artist disco, ignoring");
        } else {
            S.a(this.a, c0188fj);
        }
    }
}
