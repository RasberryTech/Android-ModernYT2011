package defpackage;

/* JADX INFO: renamed from: fg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0185fg implements Runnable {
    private /* synthetic */ C0180fb a;

    /* synthetic */ RunnableC0185fg(C0180fb c0180fb) {
        this(c0180fb, (byte) 0);
    }

    private RunnableC0185fg(C0180fb c0180fb, byte b) {
        this.a = c0180fb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0183fe c0183fe;
        synchronized (this.a.b) {
            c0183fe = this.a.a.size() > 0 ? (C0183fe) this.a.a.elementAt(0) : null;
        }
        if (c0183fe != null) {
            c0183fe.a();
        }
    }
}
