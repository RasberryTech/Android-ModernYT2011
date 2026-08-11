package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: az, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0026az extends AbstractC0025ay {
    private final Executor a;
    private final aB b;
    private final HashMap c = new HashMap();

    public C0026az(Executor executor, aB aBVar) {
        this.a = executor;
        this.b = aBVar;
    }

    @Override // defpackage.aB
    public final void a(Object obj, Object obj2) {
        synchronized (this.c) {
            this.c.put(obj, obj2);
        }
        this.a.execute(new aA(this, obj, obj2));
    }

    @Override // defpackage.aB
    public final Object a(Object obj) {
        Object objA;
        synchronized (this.c) {
            objA = this.c.get(obj);
            if (objA != null) {
                a();
                String str = "Hit (put pending). [ratio=" + d() + "]";
            } else {
                objA = this.b.a(obj);
                if (objA != null) {
                    a();
                } else {
                    b();
                }
            }
        }
        return objA;
    }

    @Override // defpackage.aB
    public final void e() {
        synchronized (this.c) {
            this.c.clear();
            this.b.e();
            c();
        }
    }

    @Override // defpackage.aB
    public final void a(gr grVar) {
        synchronized (this.c) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (grVar.a(it.next())) {
                    it.remove();
                }
            }
            this.b.a(grVar);
        }
    }
}
