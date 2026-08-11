package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class P implements aJ {
    /* synthetic */ P() {
        this((byte) 0);
    }

    private P(byte b) {
    }

    @Override // defpackage.aJ
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2, aB aBVar) {
        C0010aj c0010aj = (C0010aj) obj2;
        for (fM fMVar : (C0200fv) c0010aj.a) {
            aBVar.a(V.b(fMVar.a), new C0010aj(fMVar, c0010aj.b));
        }
    }
}
