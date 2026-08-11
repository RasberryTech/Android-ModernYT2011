package com.google.android.youtube.ui;

import com.google.android.youtube.C0081l;
import defpackage.C0199fu;
import defpackage.InterfaceC0002ab;

/* JADX INFO: loaded from: classes.dex */
final class U implements defpackage.I {
    private /* synthetic */ S a;

    U(S s) {
        this.a = s;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.b("failed to get disco results for ID " + ((String) obj) + " : " + exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        C0199fu c0199fu = (C0199fu) ((InterfaceC0002ab) obj2).a();
        if (c0199fu != null) {
            this.a.o = c0199fu;
            this.a.c();
            this.a.b(c0199fu.b);
        }
    }
}
