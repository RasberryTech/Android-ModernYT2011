package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aC extends AbstractC0025ay {
    private final int a;
    private final LinkedHashMap b;

    public aC(int i) {
        this.a = i;
        this.b = new aD(this, ((int) Math.ceil(i / 0.75f)) + 1, 0.75f, true);
    }

    @Override // defpackage.aB
    public final void e() {
        synchronized (this.b) {
            c();
            this.b.clear();
        }
    }

    @Override // defpackage.aB
    public final Object a(Object obj) {
        Object obj2;
        synchronized (this.b) {
            obj2 = this.b.get(obj);
            if (obj2 != null) {
                a();
                String str = "Hit. [ratio = " + d() + "]";
            } else {
                b();
                String str2 = "Miss. [ratio = " + d() + "]";
            }
        }
        return obj2;
    }

    @Override // defpackage.aB
    public final void a(Object obj, Object obj2) {
        synchronized (this.b) {
            try {
                if (obj2 == null) {
                    throw new IllegalArgumentException();
                }
                this.b.put(obj, obj2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.aB
    public final void a(gr grVar) {
        synchronized (this.b) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                if (grVar.a(it.next())) {
                    it.remove();
                }
            }
        }
    }
}
