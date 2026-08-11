package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class aH implements Runnable {
    private /* synthetic */ aF a;

    aH(aF aFVar) {
        this.a = aFVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        aF.a(this.a);
        this.a.e.open();
    }
}
