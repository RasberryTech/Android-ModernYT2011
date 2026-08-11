package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class dY extends dX {
    private int a;

    public dY(dZ dZVar, Runnable runnable) {
        this(dZVar, runnable, dZVar.a());
    }

    private dY(dZ dZVar, Runnable runnable, int i) {
        super(dZVar, runnable);
        this.a = i;
    }

    @Override // defpackage.dX
    public int c() {
        return this.b.c(this) ? 1 : 0;
    }

    @Override // defpackage.dX
    protected void f() {
        this.b.a(this);
    }

    public final synchronized int h() {
        return this.a;
    }
}
