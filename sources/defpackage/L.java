package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class L implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ String b;
    private /* synthetic */ long c;

    L(J j, String str, String str2, long j2) {
        this.a = str;
        this.b = str2;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gv.a(this.a, this.b, this.c);
    }
}
