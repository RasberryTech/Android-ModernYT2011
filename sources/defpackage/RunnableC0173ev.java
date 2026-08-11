package defpackage;

/* JADX INFO: renamed from: ev, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0173ev implements Runnable {
    private /* synthetic */ eN a;
    private /* synthetic */ boolean b;
    private /* synthetic */ C0171et c;

    RunnableC0173ev(C0171et c0171et, eN eNVar, boolean z) {
        this.c = c0171et;
        this.a = eNVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a, this.b);
    }
}
