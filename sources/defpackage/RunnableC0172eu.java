package defpackage;

/* JADX INFO: renamed from: eu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0172eu implements Runnable {
    private /* synthetic */ C0171et a;

    RunnableC0172eu(C0171et c0171et) {
        this.a = c0171et;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a.a) {
            if (System.currentTimeMillis() < this.a.d) {
                this.a.e.b(this.a.d);
                this.a.e.e();
            } else {
                this.a.d = 0L;
                this.a.c = 0L;
                this.a.d();
            }
        }
    }
}
