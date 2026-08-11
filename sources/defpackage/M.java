package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class M implements aJ {
    /* synthetic */ M() {
        this((byte) 0);
    }

    private M(byte b) {
    }

    @Override // defpackage.aJ
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2, aB aBVar) {
        C0010aj c0010aj = (C0010aj) obj2;
        long j = c0010aj.b;
        for (C0199fu c0199fu : ((C0188fj) c0010aj.a).c) {
            aBVar.a(c0199fu.a, new C0010aj(c0199fu, j));
        }
        for (C0199fu c0199fu2 : ((C0188fj) c0010aj.a).b) {
            aBVar.a(c0199fu2.a, new C0010aj(c0199fu2, j));
        }
    }
}
