package com.google.android.youtube.widget;

import defpackage.I;
import defpackage.InterfaceC0004ad;
import defpackage.U;
import defpackage.gq;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0004ad {
    private final InterfaceC0004ad a;
    private final ConcurrentMap b;
    private final InterfaceC0004ad c;

    public b(InterfaceC0004ad interfaceC0004ad, ConcurrentMap concurrentMap, InterfaceC0004ad interfaceC0004ad2) {
        this.a = (InterfaceC0004ad) gq.a(interfaceC0004ad);
        this.b = (ConcurrentMap) gq.a(concurrentMap);
        this.c = (InterfaceC0004ad) gq.a(interfaceC0004ad2);
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(U u, I i) {
        this.a.a(u, new c(this, i));
    }
}
