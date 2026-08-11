package com.google.android.youtube.ui;

import defpackage.C0188fj;
import defpackage.C0199fu;

/* JADX INFO: loaded from: classes.dex */
final class T implements defpackage.I {
    private /* synthetic */ S a;

    T(S s) {
        this.a = s;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0093f.b(this.a.a, exc);
        this.a.a.finish();
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.a.a.a(((C0199fu) ((C0188fj) obj2).c.get(0)).a);
    }
}
