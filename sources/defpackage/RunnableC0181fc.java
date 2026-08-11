package defpackage;

/* JADX INFO: renamed from: fc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0181fc implements Runnable {
    private eW a;
    private eP b;
    private Exception c;
    private long d;
    private long e;
    private int f = 4;

    public RunnableC0181fc(eW eWVar, long j, long j2) {
        this.a = eWVar;
        this.d = j;
        this.e = j2;
    }

    public RunnableC0181fc(eW eWVar, eP ePVar) {
        this.a = eWVar;
        this.b = ePVar;
    }

    public RunnableC0181fc(eW eWVar, Exception exc) {
        this.a = eWVar;
        this.c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.c() == null) {
        }
    }
}
