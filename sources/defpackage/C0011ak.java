package defpackage;

/* JADX INFO: renamed from: ak, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0011ak implements InterfaceC0004ad {
    private final aB a;
    private final InterfaceC0004ad b;
    private final gn c;
    private final long d;

    public static C0011ak a(aB aBVar, InterfaceC0004ad interfaceC0004ad, gn gnVar, long j) {
        gq.a(aBVar, "cache may not be null");
        gq.a(interfaceC0004ad, "target may not be null");
        gq.a(gnVar, "clock may not be null");
        gq.a(j >= 0 && j <= 2592000000L, "time to live must be >=0 and <= 2592000000");
        return new C0011ak(aBVar, interfaceC0004ad, gnVar, j);
    }

    private C0011ak(aB aBVar, InterfaceC0004ad interfaceC0004ad, gn gnVar, long j) {
        this.a = aBVar;
        this.b = interfaceC0004ad;
        this.c = gnVar;
        this.d = j;
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(Object obj, I i) {
        C0010aj c0010aj = (C0010aj) this.a.a(obj);
        long jA = this.c.a();
        if (c0010aj != null && jA >= c0010aj.b && c0010aj.b + this.d >= jA) {
            i.a(obj, c0010aj.a);
        } else {
            this.b.a(obj, new C0012al(this, i));
        }
    }
}
