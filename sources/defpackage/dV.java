package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class dV extends Thread {
    private String a;
    private Runnable b;
    private /* synthetic */ dU c;

    public dV(dU dUVar, String str, Runnable runnable) {
        this.c = dUVar;
        dUVar.a();
        this.a = str;
        this.b = runnable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.c.b();
            this.b.run();
        } catch (Throwable th) {
            th.printStackTrace();
        } finally {
            this.c.c();
        }
    }

    @Override // java.lang.Thread
    public final String toString() {
        return "Thread[" + this.a + "," + getPriority() + "]";
    }
}
