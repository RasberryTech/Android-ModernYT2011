package defpackage;

/* JADX INFO: renamed from: dg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0132dg implements InterfaceC0137dl {
    private Exception a;
    private dX b;
    private int c;

    protected AbstractC0132dg() {
        j();
    }

    private synchronized void a(int i) {
        this.c = i;
    }

    private synchronized void b(Exception exc) {
        this.a = exc;
    }

    private synchronized void i() {
        a(4);
    }

    private synchronized void j() {
        this.c = 0;
    }

    private synchronized void k() {
        if (this.b != null) {
            this.b.e();
        }
    }

    protected final synchronized void a() {
        if (this.c != 2) {
            throw new IllegalStateException("state != STATE_COMPLETED");
        }
    }

    protected final synchronized void a(dX dXVar) {
        this.b = dXVar;
    }

    protected final synchronized void a(Exception exc) {
        a(3);
        b(exc);
        k();
    }

    public synchronized void b() {
        i();
    }

    @Override // defpackage.InterfaceC0137dl
    public final synchronized Exception c() {
        return this.a;
    }

    public final synchronized int c_() {
        return this.c;
    }

    @Override // defpackage.InterfaceC0137dl
    public final synchronized boolean d() {
        return this.a != null;
    }

    public final synchronized boolean d_() {
        return this.c == 2 || this.c == 3;
    }

    protected final synchronized void e_() {
        a(1);
    }

    protected final synchronized void h() {
        a(2);
        k();
    }
}
