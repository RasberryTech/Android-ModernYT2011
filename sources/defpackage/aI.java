package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class aI implements aB {
    private final aB a;
    private final aB b;
    private final aJ c;

    public aI(aB aBVar, aB aBVar2, aJ aJVar) {
        this.a = (aB) gq.a(aBVar, "compoundCache may not be null");
        this.b = (aB) gq.a(aBVar2, "singleElementsCache may not be null");
        this.c = (aJ) gq.a(aJVar, "splitter may not be null");
    }

    @Override // defpackage.aB
    public final void a(Object obj, Object obj2) {
        this.c.a(obj, obj2, this.b);
        this.a.a(obj, obj2);
    }

    @Override // defpackage.aB
    public final Object a(Object obj) {
        return this.a.a(obj);
    }

    @Override // defpackage.aB
    public final void e() {
        this.a.e();
    }

    @Override // defpackage.aB
    public final void a(gr grVar) {
        this.a.a(grVar);
    }
}
