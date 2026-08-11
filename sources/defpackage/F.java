package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class F implements Runnable {
    private I a;
    private Object b;
    private Object c;
    private Exception d;
    private boolean e;

    /* synthetic */ F() {
        this((byte) 0);
    }

    private F(byte b) {
    }

    public final void a(I i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = null;
        this.e = true;
    }

    public final void a(I i, Object obj, Exception exc) {
        this.a = i;
        this.b = obj;
        this.d = exc;
        this.c = null;
        this.e = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e) {
            this.a.a(this.b, this.c);
        } else {
            this.a.a(this.b, this.d);
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        E.a(this);
    }
}
