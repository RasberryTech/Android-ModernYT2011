package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class dU implements dW {
    private int a = 0;
    private int b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.a++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        this.b++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        this.b--;
    }

    @Override // defpackage.dW
    public final Thread a(String str, Runnable runnable) {
        return new dV(this, str, runnable);
    }
}
