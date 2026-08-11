package defpackage;

/* JADX INFO: renamed from: gd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0209gd extends gE {
    private C0208gc a;

    private C0209gd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0209gd e() {
        C0209gd c0209gd = new C0209gd();
        c0209gd.a = new C0208gc();
        return c0209gd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gE, defpackage.gy
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0209gd clone() {
        C0209gd c0209gdE = e();
        C0208gc c0208gc = this.a;
        if (c0208gc != C0208gc.a()) {
            if (c0208gc.b()) {
                c0209gdE.a(c0208gc.c());
            }
            if (c0208gc.d()) {
                c0209gdE.b(c0208gc.e());
            }
            if (c0208gc.f()) {
                c0209gdE.c(c0208gc.g());
            }
            if (c0208gc.h()) {
                c0209gdE.d(c0208gc.i());
            }
            if (c0208gc.k()) {
                c0209gdE.e(c0208gc.l());
            }
            if (c0208gc.m()) {
                c0209gdE.a(c0208gc.n());
            }
            if (c0208gc.o()) {
                c0209gdE.b(c0208gc.p());
            }
            if (c0208gc.q()) {
                c0209gdE.c(c0208gc.r());
            }
            if (c0208gc.s()) {
                c0209gdE.a(c0208gc.t());
            }
        }
        return c0209gdE;
    }

    public final C0208gc a() {
        if (this.a == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
        }
        C0208gc c0208gc = this.a;
        this.a = null;
        return c0208gc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gy, defpackage.gH
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0209gd b(gz gzVar, gC gCVar) throws gF {
        while (true) {
            int iA = gzVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 10:
                    a(gzVar.d());
                    break;
                case 18:
                    b(gzVar.d());
                    break;
                case 26:
                    c(gzVar.d());
                    break;
                case 34:
                    d(gzVar.d());
                    break;
                case 42:
                    e(gzVar.d());
                    break;
                case 48:
                    a(gzVar.c());
                    break;
                case 56:
                    b(gzVar.c());
                    break;
                case 64:
                    c(gzVar.c());
                    break;
                case 88:
                    a(gzVar.b());
                    break;
                default:
                    if (!gzVar.b(iA)) {
                        return this;
                    }
                    break;
                    break;
            }
        }
    }

    private C0209gd a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        C0208gc.a(this.a, true);
        this.a.c = str;
        return this;
    }

    private C0209gd b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        C0208gc.b(this.a, true);
        this.a.e = str;
        return this;
    }

    private C0209gd c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        C0208gc.c(this.a, true);
        this.a.g = str;
        return this;
    }

    private C0209gd d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        C0208gc.d(this.a, true);
        this.a.i = str;
        return this;
    }

    private C0209gd e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        C0208gc.e(this.a, true);
        this.a.k = str;
        return this;
    }

    private C0209gd a(boolean z) {
        C0208gc.f(this.a, true);
        this.a.m = z;
        return this;
    }

    private C0209gd b(boolean z) {
        C0208gc.h(this.a, true);
        this.a.o = z;
        return this;
    }

    private C0209gd c(boolean z) {
        C0208gc.j(this.a, true);
        this.a.q = z;
        return this;
    }

    private C0209gd a(int i) {
        C0208gc.l(this.a, true);
        this.a.s = i;
        return this;
    }
}
