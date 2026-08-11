package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements InterfaceC0004ad {
    private final gm a;
    private final aM b;
    private final aN c;
    private final boolean d = true;

    public Z(gm gmVar, aM aMVar, aN aNVar, boolean z) {
        this.a = (gm) gq.a(gmVar, "masf may not be null");
        this.b = (aM) gq.a(aMVar, "requestConverter may not be null");
        this.c = (aN) gq.a(aNVar, "responseConverter may not be null");
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(Object obj, I i) {
        gq.a(obj, "request may not be null");
        gq.a(i, "callback may not be null");
        try {
            eN eNVar = (eN) this.b.b(obj);
            eNVar.a(new C0001aa(obj, i, this.c));
            this.a.a(eNVar, this.d);
        } catch (aK e) {
            i.a(obj, (Exception) e);
        }
    }
}
