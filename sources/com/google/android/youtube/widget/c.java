package com.google.android.youtube.widget;

import defpackage.C0200fv;
import defpackage.I;
import defpackage.U;
import defpackage.fM;
import defpackage.gq;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class c implements I {
    private final I a;
    private /* synthetic */ b b;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        this.a.a(obj, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        int i;
        U u = (U) obj;
        C0200fv c0200fv = (C0200fv) obj2;
        String str = "widget gets " + c0200fv.d.size() + " videos";
        List<fM> list = c0200fv.d;
        int i2 = 0;
        Iterator it = list.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            } else {
                i2 = ((fM) it.next()).d != null ? i + 1 : i;
            }
        }
        String str2 = "widget expects " + i + " thumbnails";
        d dVar = new d(u, this.a, i, list, this.b.b);
        for (fM fMVar : list) {
            if (fMVar.d != null) {
                this.b.c.a(fMVar.d, dVar);
            }
        }
    }

    public c(b bVar, I i) {
        this.b = bVar;
        this.a = (I) gq.a(i);
    }
}
