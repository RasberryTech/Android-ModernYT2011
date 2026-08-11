package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class cF implements aM {
    private final String a;
    private final int b;

    public cF(String str, int i) {
        gq.a(i >= 0, "service version number should be > 0");
        gq.a(i <= 65535, "service version should be <= 0xffff");
        this.b = i;
        this.a = (String) gq.a((Object) str, (Object) "service string can't be null");
    }

    @Override // defpackage.aM
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final eN b(gG gGVar) {
        return new eK(this.a, this.b, gGVar.w());
    }
}
