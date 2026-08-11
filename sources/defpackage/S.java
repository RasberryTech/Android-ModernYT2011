package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class S implements InterfaceC0004ad {
    private final gr a;
    private final aB b;
    private final InterfaceC0004ad c;

    public S(gr grVar, aB aBVar, InterfaceC0004ad interfaceC0004ad) {
        this.a = (gr) gq.a(grVar, "filter may not be null");
        this.b = (aB) gq.a(aBVar, "cache may not be null");
        this.c = (InterfaceC0004ad) gq.a(interfaceC0004ad, "target may not be null");
    }

    protected S(aB aBVar, InterfaceC0004ad interfaceC0004ad) {
        this.b = (aB) gq.a(aBVar, "cache may not be null");
        this.c = (InterfaceC0004ad) gq.a(interfaceC0004ad, "target may not be null");
        this.a = null;
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(Object obj, I i) {
        this.c.a(obj, new T(this, i));
    }

    protected gr a(Object obj, Object obj2) {
        return this.a;
    }
}
