package com.google.android.youtube.ui;

import com.google.android.youtube.C0081l;
import defpackage.fH;
import defpackage.fM;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: loaded from: classes.dex */
final class K extends AbstractC0092e implements defpackage.I {
    private /* synthetic */ J a;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        if (!(exc instanceof HttpResponseException) || ((HttpResponseException) exc).getStatusCode() != 400) {
            C0081l.a("Error adding to favorites", exc.getCause());
            C0093f.b(this.a.a, exc);
        } else {
            this.a.b(com.google.android.youtube.R.string.added_to_favorites_duplicate);
        }
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.a.a(((fM) obj2).e);
        this.a.b(com.google.android.youtube.R.string.added_to_favorites);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(J j) {
        super(j.a);
        this.a = j;
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.a.c.a(defpackage.V.a(this.a.s.a, fHVar), new defpackage.E(this.a.a, this));
    }
}
