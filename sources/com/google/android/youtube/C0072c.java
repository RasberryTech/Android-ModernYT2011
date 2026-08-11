package com.google.android.youtube;

import defpackage.fK;
import defpackage.fL;
import defpackage.fM;

/* JADX INFO: renamed from: com.google.android.youtube.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0072c implements defpackage.I {
    private final String a;
    private final fK b;
    private /* synthetic */ C0070a c;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error retrieving video for the ad", exc);
        this.c.e.a((Object) this.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        fM fMVar = (fM) obj2;
        if (fMVar != null) {
            defpackage.I i = this.c.e;
            String str = this.a;
            fK fKVar = this.b;
            i.a(str, new fL().a(fKVar.a).b(fKVar.b).c(fKVar.c).d(fKVar.d).e(fKVar.e).f(fKVar.f).g(fKVar.g).h(fKVar.h).i(fKVar.i).b(fMVar.a(this.c.j)).a());
            return;
        }
        this.c.e.a(this.a, (Object) null);
    }

    public C0072c(C0070a c0070a, String str, fK fKVar) {
        this.c = c0070a;
        this.a = str;
        this.b = fKVar;
    }
}
