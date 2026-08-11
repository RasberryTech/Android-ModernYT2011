package defpackage;

/* JADX INFO: renamed from: ay, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0025ay implements aB {
    private int a = 0;
    private int b = 0;

    protected final void a() {
        this.a++;
    }

    protected final void b() {
        this.b++;
    }

    protected final void c() {
        this.a = 0;
        this.b = 0;
    }

    public final int d() {
        int i = this.a + this.b;
        if (i == 0) {
            return 0;
        }
        return (this.a * 100) / i;
    }
}
