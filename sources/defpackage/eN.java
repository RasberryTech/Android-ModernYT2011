package defpackage;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class eN extends eB implements InterfaceC0170es {
    private eO a;
    private long b = 2000;
    private int c = 1;

    public abstract int a();

    public final synchronized void a(eO eOVar) {
        this.a = eOVar;
    }

    public abstract InputStream b();

    public final synchronized void b(int i) {
        this.c = 0;
    }

    public synchronized long d() {
        long j;
        j = this.b;
        this.b <<= 1;
        return j;
    }

    public synchronized boolean e() {
        int i;
        i = this.c;
        this.c = i - 1;
        return i > 0;
    }

    public abstract void f();

    public final synchronized eO i() {
        return this.a;
    }
}
