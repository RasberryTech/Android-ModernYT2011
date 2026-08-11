package com.google.android.youtube.ui;

import com.google.android.youtube.C0081l;
import defpackage.fH;

/* JADX INFO: loaded from: classes.dex */
final class N extends AbstractC0092e implements defpackage.I {
    private final boolean a;
    private /* synthetic */ J b;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error rating", exc);
        C0093f.b(this.b.a, exc);
        J.a(this.b, this.b.i, false);
        J.a(this.b, this.b.j, false);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.b.b(this.a ? com.google.android.youtube.R.string.rating_like : com.google.android.youtube.R.string.rating_dislike);
        this.b.r.a(this.a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(J j, boolean z) {
        super(j.a);
        this.b = j;
        this.a = z;
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        J.a(this.b, this.b.i, this.a);
        J.a(this.b, this.b.j, !this.a);
        this.b.b.a(defpackage.V.a(this.b.s.a, fHVar.b, this.a), new defpackage.E(this.b.a, this));
    }
}
