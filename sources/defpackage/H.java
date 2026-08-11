package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class H implements Runnable {
    private /* synthetic */ Object a;
    private /* synthetic */ I b;
    private /* synthetic */ G c;

    H(G g, Object obj, I i) {
        this.c = g;
        this.a = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b.a(this.a, this.b);
    }
}
