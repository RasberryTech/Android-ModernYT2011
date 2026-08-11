package defpackage;

import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class J implements InterfaceC0005ae, InterfaceC0022av {
    private InterfaceC0004ad A;
    private InterfaceC0004ad B;
    private InterfaceC0004ad C;
    private InterfaceC0004ad D;
    private InterfaceC0004ad E;
    private InterfaceC0004ad F;
    private InterfaceC0004ad G;
    private gm H;
    private InterfaceC0004ad I;
    private InterfaceC0004ad J;
    private InterfaceC0004ad K;
    private InterfaceC0004ad L;
    private InterfaceC0004ad M;
    private InterfaceC0004ad N;
    private InterfaceC0004ad O;
    private InterfaceC0004ad P;
    private InterfaceC0004ad Q;
    private InterfaceC0004ad R;
    private InterfaceC0004ad S;
    private InterfaceC0004ad T;
    private aB U;
    private InterfaceC0004ad V;
    private InterfaceC0004ad W;
    private InterfaceC0004ad X;
    private InterfaceC0004ad Y;
    private final Executor a;
    private final HttpClient b;
    private final gn c;
    private final String d;
    private final aW e;
    private bQ f;
    private C0046bs g;
    private C0046bs h;
    private C0046bs i;
    private C0056cb j;
    private aB k;
    private aB l;
    private aB m;
    private aB n;
    private aB o;
    private InterfaceC0004ad p;
    private InterfaceC0004ad q;
    private InterfaceC0004ad r;
    private InterfaceC0004ad s;
    private InterfaceC0004ad t;
    private InterfaceC0004ad u;
    private InterfaceC0004ad v;
    private InterfaceC0004ad w;
    private InterfaceC0004ad x;
    private InterfaceC0004ad y;
    private InterfaceC0004ad z;

    public J(Executor executor, HttpClient httpClient, gn gnVar, String str, aW aWVar) {
        gq.a(executor, "executor can't be null");
        gq.a(httpClient, "httpClient can't be null");
        gq.a(gnVar, "clock can't be null");
        gq.a(str, (Object) "cache path can't be empty");
        gq.a(aWVar, "parser can't be null");
        this.a = executor;
        this.b = httpClient;
        this.c = gnVar;
        this.d = str;
        this.e = aWVar;
    }

    public final void a(Q q, C0013am c0013am, String str, String str2) {
        gq.a(q);
        gq.a(c0013am);
        this.a.execute(new L(this, this.d, ".cache", 2097152L));
        c0013am.a(this);
        this.f = new bQ(EnumC0047bt.a);
        this.g = new C0046bs(EnumC0047bt.a, q);
        this.h = new C0046bs(EnumC0047bt.b, "application/atom+xml", q);
        this.i = new C0046bs(EnumC0047bt.c, "application/atom+xml", q);
        this.p = a(a(250), a(a(this.f, new C0030bc())), 86400000L);
        this.T = new Y(this.b, this.f);
        this.k = a(500);
        this.j = new C0056cb(this.e);
        this.q = a(this.k, a(a(this.g, this.j)), 14400000L);
        this.l = a(50);
        this.m = new C0026az(this.a, M());
        this.n = new aI(this.l, this.k, new P());
        this.r = a(this.g, new C0055ca(this.e));
        this.o = a(20);
        this.s = a(this.n, a(a(this.m, this.r, 86400000L)), 7200000L);
        this.t = a(a(20), a(a(this.g, new bR())), 1800000L);
        this.x = a(a(50), a(a(this.g, new C0037bj())), 7200000L);
        this.u = a(a(1), a(a(M(), a(this.g, new C0034bg()), 604800000L)), 7200000L);
        this.v = a(a(20), a(a(this.g, new C0039bl(this.e))), 7200000L);
        this.w = a(a(50), a(a(this.g, new C0052by(this.e))), 1800000L);
        this.y = a(a(20), a(a(M(), a(this.g, new C0031bd(this.e)), 86400000L)), 7200000L);
        bP bPVar = new bP();
        this.z = a(a(20), a(a(M(), a(bPVar, bPVar), 604800000L)), 7200000L);
        bO bOVar = new bO();
        this.A = a(a(20), a(a(M(), a(bOVar, bOVar), 604800000L)), 7200000L);
        C0029bb c0029bb = new C0029bb(c0013am, str2);
        this.R = a(a(c0029bb, c0029bb));
        this.S = a(a(this.f, new bT(this.e)));
        this.B = c0013am.a(this.s);
        this.C = c0013am.a(this.t);
        this.D = c0013am.a(a(this.n, a(this.r), 300000L));
        this.E = c0013am.a(a(this.n, a(this.r), 1800000L));
        this.F = c0013am.a(this.w);
        this.G = a(this.o, a(c0013am.a(a(this.g, new bG(this.e)))), 1800000L);
        this.I = c0013am.a(a(this.h));
        this.J = G.a(this.a, this.I);
        this.K = c0013am.a(a(this.i));
        this.L = a(a(new go("subscriptions"), this.o, this.I));
        this.M = a(a(new go("subscriptions"), this.o, this.K));
        this.N = a(new N(this.l, this.I));
        this.O = a(a(new go("favorites"), this.l, c0013am.a(a(this.h, this.j))));
        this.P = a(a(new go("favorites"), this.l, this.K));
        this.Q = a(a(new go("uploads"), this.l, this.K));
        this.H = new gm();
        this.U = a(500);
        this.V = new Z(this.H, new cD("g:nsc/mv", 1, str), new cE(), true);
        this.W = a(this.U, a(new C0006af(this.V)), 7200000L);
        InterfaceC0004ad interfaceC0004ad = this.V;
        aB aBVar = this.U;
        this.X = a(new aI(a(50), aBVar, new aE()), a(a(M(), interfaceC0004ad, 86400000L)), 7200000L);
        InterfaceC0004ad z = new Z(this.H, new cA("g:nsc/ma", 1, str), new cB(), true);
        aB aBVar2 = this.U;
        this.Y = a(new aI(new aC(20), aBVar2, new M()), a(a(M(), z, 86400000L)), 7200000L);
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad a() {
        return this.q;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad b() {
        return this.s;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad c() {
        return this.s;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad d() {
        return this.x;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad e() {
        return this.p;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad f() {
        return this.t;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad g() {
        return this.C;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad h() {
        return this.s;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad i() {
        return this.D;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad j() {
        return this.Q;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad k() {
        return this.s;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad l() {
        return this.E;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad m() {
        return this.w;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad n() {
        return this.F;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad o() {
        return this.G;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad p() {
        return this.B;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad q() {
        return this.B;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad r() {
        return this.u;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad s() {
        return this.s;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad t() {
        return this.v;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad u() {
        return this.J;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad v() {
        return this.O;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad w() {
        return this.P;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad x() {
        return this.L;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad y() {
        return this.M;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad z() {
        return this.N;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad A() {
        return this.s;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad B() {
        return this.s;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad C() {
        return this.z;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad D() {
        return this.A;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad E() {
        return this.T;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad F() {
        return this.R;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad G() {
        return this.S;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad H() {
        return this.y;
    }

    @Override // defpackage.InterfaceC0022av
    public final void I() {
        this.a.execute(new K(this));
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad J() {
        return this.W;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad K() {
        return this.X;
    }

    @Override // defpackage.InterfaceC0005ae
    public final InterfaceC0004ad L() {
        return this.Y;
    }

    private Y a(aM aMVar, aN aNVar) {
        return new Y(this.b, aMVar, aNVar);
    }

    private Y a(aM aMVar) {
        return new Y(this.b, aMVar);
    }

    private G a(InterfaceC0004ad interfaceC0004ad) {
        return G.a(this.a, interfaceC0004ad);
    }

    private static aC a(int i) {
        return new aC(i);
    }

    private C0011ak a(aB aBVar, InterfaceC0004ad interfaceC0004ad, long j) {
        return C0011ak.a(aBVar, interfaceC0004ad, this.c, j);
    }

    private static S a(gr grVar, aB aBVar, InterfaceC0004ad interfaceC0004ad) {
        return new S(grVar, aBVar, interfaceC0004ad);
    }

    private aF M() {
        return new aF(this.d, ".cache").a(this.a);
    }
}
