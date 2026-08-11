package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class aA implements Runnable {
    private /* synthetic */ Object a;
    private /* synthetic */ Object b;
    private /* synthetic */ C0026az c;

    aA(C0026az c0026az, Object obj, Object obj2) {
        this.c = c0026az;
        this.a = obj;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b.a(this.a, this.b);
        synchronized (this.c.c) {
            this.c.c.remove(this.a);
        }
    }
}
