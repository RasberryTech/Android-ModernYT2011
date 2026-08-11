package com.google.android.youtube.widget;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.youtube.C0081l;
import defpackage.I;
import defpackage.U;
import defpackage.fM;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
final class d implements I {
    private final U a;
    private final I b;
    private final AtomicInteger c;
    private final ConcurrentHashMap d;
    private final List e;
    private final Map f;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.b("widget thumbnail error", exc);
        a();
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.d.put((Uri) obj, (Bitmap) obj2);
        a();
    }

    public d(U u, I i, int i2, List list, Map map) {
        this.a = u;
        this.b = i;
        this.e = list;
        this.f = map;
        this.c = new AtomicInteger(i2);
        this.d = new ConcurrentHashMap(i2);
    }

    private void a() {
        if (this.c.decrementAndGet() == 0) {
            ArrayList arrayList = new ArrayList(this.e.size());
            for (fM fMVar : this.e) {
                if (fMVar.d != null) {
                    Bitmap bitmap = (Bitmap) this.d.get(fMVar.d);
                    Integer num = (Integer) this.f.get(fMVar.a);
                    if (bitmap != null && num != null && !TextUtils.isEmpty(fMVar.a)) {
                        arrayList.add(new a(fMVar, bitmap, num.intValue()));
                    }
                }
            }
            this.b.a(this.a, arrayList);
        }
    }
}
