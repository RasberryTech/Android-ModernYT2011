package com.google.android.youtube.ui;

import android.net.Uri;
import com.google.android.youtube.C0081l;
import defpackage.fH;

/* JADX INFO: loaded from: classes.dex */
final class O extends AbstractC0092e implements defpackage.I {
    private /* synthetic */ J a;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error adding or removing favorite", exc.getCause());
        C0093f.b(this.a.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.a.a((Uri) null);
        this.a.b(com.google.android.youtube.R.string.removed_from_favorites);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(J j) {
        super(j.a);
        this.a = j;
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.a.d.a(defpackage.V.a(this.a.t, fHVar), new defpackage.E(this.a.a, this));
    }
}
