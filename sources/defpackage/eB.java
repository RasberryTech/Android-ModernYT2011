package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class eB {
    private int a;

    public synchronized void a(int i) {
        this.a = i;
    }

    public final synchronized int c() {
        return this.a;
    }
}
