package defpackage;

import com.google.android.youtube.C0081l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: ai, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0009ai implements I {
    private final I a;
    private final U b;
    private final HashMap c;
    private final ConcurrentHashMap d;
    private final U e;
    private int f;
    private final ArrayList g;
    private Exception h;
    private final ArrayList i = new ArrayList();

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        a(exc);
    }

    public C0009ai(I i, U u, HashMap map, ConcurrentHashMap concurrentHashMap, U u2) {
        this.a = i;
        this.b = u;
        this.c = map;
        this.d = concurrentHashMap;
        this.e = u2;
        this.f = map.size();
        this.g = new ArrayList(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.I
    public synchronized void a(U u, C0200fv c0200fv) {
        Integer num = (Integer) this.c.get(u);
        Iterator it = c0200fv.d.iterator();
        while (it.hasNext()) {
            this.d.putIfAbsent(((fM) it.next()).a, num);
        }
        if (u == this.e) {
            this.i.addAll(c0200fv.d);
        } else {
            this.g.add(c0200fv.d);
        }
        a();
    }

    private synchronized void a(Exception exc) {
        C0081l.a("onError in the feed", exc);
        this.h = exc;
        a();
    }

    private void a() {
        boolean z;
        boolean z2;
        this.f--;
        if (this.f == 0) {
            ArrayList<List> arrayList = this.g;
            ArrayList arrayList2 = this.i;
            int i = 0;
            for (boolean z3 = false; !z3; z3 = z) {
                z = true;
                for (List list : arrayList) {
                    if (i < list.size()) {
                        fM fMVar = (fM) list.get(i);
                        if (!arrayList2.contains(fMVar)) {
                            arrayList2.add(fMVar);
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    z = z2;
                }
                i++;
            }
            this.g.clear();
            if (this.i.size() > 0) {
                this.a.a(this.b, new C0200fv(this.i.size(), this.i.size(), 1, null, null, this.i));
                if (this.h != null) {
                    this.a.a((Object) this.b, new Exception("some feed sources failed", this.h));
                    return;
                }
                return;
            }
            this.a.a((Object) this.b, new Exception("all feed sources failed", this.h));
        }
    }
}
