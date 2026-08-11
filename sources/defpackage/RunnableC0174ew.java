package defpackage;

/* JADX INFO: renamed from: ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0174ew implements Runnable {
    private /* synthetic */ InterfaceC0133dh a;
    private /* synthetic */ eN[] b;
    private /* synthetic */ int c;
    private /* synthetic */ C0171et d;

    RunnableC0174ew(C0171et c0171et, InterfaceC0133dh interfaceC0133dh, eN[] eNVarArr, int i) {
        this.d = c0171et;
        this.a = interfaceC0133dh;
        this.b = eNVarArr;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.d()) {
                C0171et c0171et = this.d;
                C0171et.a(this.b, this.a.c());
            } else {
                C0171et.a(this.d, this.a, this.b);
            }
            C0171et.a(this.d, this.b);
            this.d.b += this.c;
        } finally {
            this.a.b();
        }
    }
}
