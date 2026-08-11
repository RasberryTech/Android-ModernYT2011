package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class dX {
    private static final dX[] a = new dX[0];
    protected dZ b;
    private Runnable c;
    private int d;
    private int e;
    private Object f = new Object();

    public dX(dZ dZVar, Runnable runnable) {
        this.b = dZVar;
        this.c = runnable;
    }

    private dX[] h() {
        dX[] dXVarArr;
        synchronized (this) {
            dXVarArr = a;
        }
        return dXVarArr;
    }

    protected void a() {
        if (this.c != null) {
            this.c.run();
        }
    }

    protected final void a(int i) {
        this.d = i;
    }

    public final int b() {
        return this.b.b(this);
    }

    protected abstract int c();

    protected final int d() {
        return this.d;
    }

    public void e() {
        synchronized (this.f) {
            this.e = 0;
        }
        this.b.a(this);
    }

    protected abstract void f();

    protected void g() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f) {
            this.e++;
            this.f.notifyAll();
        }
        for (dX dXVar : h()) {
            dXVar.e();
        }
    }
}
