package com.google.android.youtube.ui;

import android.widget.Toast;
import com.google.android.youtube.C0081l;
import defpackage.C0202fx;
import defpackage.fH;

/* JADX INFO: loaded from: classes.dex */
final class L extends AbstractC0092e implements defpackage.I {
    private final C0202fx a;
    private /* synthetic */ J b;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error adding video to playlist", exc);
        C0093f.b(this.b.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        Toast.makeText(this.b.a, this.b.a.getString(com.google.android.youtube.R.string.add_to_playlist, new Object[]{this.a.a}), 1).show();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(J j, C0202fx c0202fx) {
        super(j.a);
        this.b = j;
        this.a = c0202fx;
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.b.f.a(defpackage.V.a(this.b.s.a, this.a.d, fHVar), new defpackage.E(this.b.a, this));
    }
}
