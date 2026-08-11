package defpackage;

import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0208gc extends gD {
    private static final C0208gc a = new C0208gc((char) 0);
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private boolean f;
    private String g;
    private boolean h;
    private String i;
    private boolean j;
    private String k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;

    /* synthetic */ C0208gc() {
        this((byte) 0);
    }

    static /* synthetic */ boolean a(C0208gc c0208gc, boolean z) {
        c0208gc.b = true;
        return true;
    }

    static /* synthetic */ boolean b(C0208gc c0208gc, boolean z) {
        c0208gc.d = true;
        return true;
    }

    static /* synthetic */ boolean c(C0208gc c0208gc, boolean z) {
        c0208gc.f = true;
        return true;
    }

    static /* synthetic */ boolean d(C0208gc c0208gc, boolean z) {
        c0208gc.h = true;
        return true;
    }

    static /* synthetic */ boolean e(C0208gc c0208gc, boolean z) {
        c0208gc.j = true;
        return true;
    }

    static /* synthetic */ boolean f(C0208gc c0208gc, boolean z) {
        c0208gc.l = true;
        return true;
    }

    static /* synthetic */ boolean h(C0208gc c0208gc, boolean z) {
        c0208gc.n = true;
        return true;
    }

    static /* synthetic */ boolean j(C0208gc c0208gc, boolean z) {
        c0208gc.p = true;
        return true;
    }

    static /* synthetic */ boolean l(C0208gc c0208gc, boolean z) {
        c0208gc.r = true;
        return true;
    }

    private C0208gc(byte b) {
        this.c = "";
        this.e = "";
        this.g = "";
        this.i = "";
        this.k = "";
        this.m = false;
        this.o = false;
        this.q = false;
        this.s = 0;
        this.t = -1;
    }

    private C0208gc(char c) {
        this.c = "";
        this.e = "";
        this.g = "";
        this.i = "";
        this.k = "";
        this.m = false;
        this.o = false;
        this.q = false;
        this.s = 0;
        this.t = -1;
    }

    public static C0208gc a() {
        return a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final boolean f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final boolean k() {
        return this.j;
    }

    public final String l() {
        return this.k;
    }

    public final boolean m() {
        return this.l;
    }

    public final boolean n() {
        return this.m;
    }

    public final boolean o() {
        return this.n;
    }

    public final boolean p() {
        return this.o;
    }

    public final boolean q() {
        return this.p;
    }

    public final boolean r() {
        return this.q;
    }

    public final boolean s() {
        return this.r;
    }

    public final int t() {
        return this.s;
    }

    public final boolean u() {
        return this.b && this.d && this.f && this.h && this.j && this.r;
    }

    @Override // defpackage.gG
    public final void a(gA gAVar) throws gB, UnsupportedEncodingException {
        j();
        if (this.b) {
            gAVar.a(1, this.c);
        }
        if (this.d) {
            gAVar.a(2, this.e);
        }
        if (this.f) {
            gAVar.a(3, this.g);
        }
        if (this.h) {
            gAVar.a(4, this.i);
        }
        if (this.j) {
            gAVar.a(5, this.k);
        }
        if (this.l) {
            gAVar.a(6, this.m);
        }
        if (this.n) {
            gAVar.a(7, this.o);
        }
        if (this.p) {
            gAVar.a(8, this.q);
        }
        if (this.r) {
            int i = this.s;
            gAVar.a(11, 0);
            if (i < 0) {
                long j = i;
                while (((-128) & j) != 0) {
                    gAVar.a((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                gAVar.a((int) j);
                return;
            }
            gAVar.c(i);
        }
    }

    @Override // defpackage.gG
    public final int j() {
        int iD = this.t;
        if (iD == -1) {
            iD = 0;
            if (this.b) {
                iD = gA.b(1, this.c) + 0;
            }
            if (this.d) {
                iD += gA.b(2, this.e);
            }
            if (this.f) {
                iD += gA.b(3, this.g);
            }
            if (this.h) {
                iD += gA.b(4, this.i);
            }
            if (this.j) {
                iD += gA.b(5, this.k);
            }
            if (this.l) {
                iD += gA.b(6, this.m);
            }
            if (this.n) {
                iD += gA.b(7, this.o);
            }
            if (this.p) {
                iD += gA.b(8, this.q);
            }
            if (this.r) {
                int i = this.s;
                iD += (i >= 0 ? gA.d(i) : 10) + gA.b(11);
            }
            this.t = iD;
        }
        return iD;
    }

    public static C0209gd v() {
        return C0209gd.e();
    }
}
