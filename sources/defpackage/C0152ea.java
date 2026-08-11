package defpackage;

/* JADX INFO: renamed from: ea, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0152ea extends dY {
    private long a;
    private long c;
    private long d;
    private long e;
    private int f;
    private boolean g;

    public C0152ea(dZ dZVar) {
        this(dZVar, null);
    }

    public C0152ea(dZ dZVar, Runnable runnable) {
        super(dZVar, runnable);
        this.a = 0L;
        this.c = -1L;
        this.d = -1L;
        this.e = -1L;
        this.f = -1;
        this.g = false;
    }

    public final synchronized void a(long j) {
        this.a = j;
    }

    public final synchronized void b(long j) {
        this.c = j;
    }

    @Override // defpackage.dY, defpackage.dX
    public final synchronized int c() {
        int i;
        if (!this.b.c(this) && this.e == -1) {
            i = 0;
        } else {
            this.e = -1L;
            i = this.f;
        }
        return i;
    }

    @Override // defpackage.dX
    public final synchronized void e() {
        if ((this.f == -1 || this.f > 0) && this.e == -1) {
            if (this.c == -1) {
                this.e = cX.a().h().a() + this.a;
            } else {
                this.e = this.c + this.a;
            }
            this.b.a((dX) this);
        }
    }

    @Override // defpackage.dY, defpackage.dX
    protected final void f() {
        this.b.a(this);
    }

    @Override // defpackage.dX
    protected final void g() {
        synchronized (this) {
            if (this.d == -1) {
                this.e = -1L;
            } else {
                if (this.f > 0) {
                    this.f--;
                }
                if (this.f == 0) {
                    this.e = -1L;
                } else {
                    this.e = cX.a().h().a() + this.d;
                }
            }
        }
        super.g();
        synchronized (this) {
            if (this.e != -1) {
                this.b.a((dX) this);
            }
        }
    }

    public final synchronized long i() {
        return this.e;
    }
}
