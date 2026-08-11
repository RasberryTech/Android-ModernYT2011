package defpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;

/* JADX INFO: renamed from: dj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0135dj extends AbstractC0132dg implements InterfaceC0133dh, Runnable {
    private RunnableC0134di b;
    private InterfaceC0146dv c;
    private InputStream d;
    private String f;
    private String g;
    private DataInputStream h;
    private String i;
    private long j;
    private int k;
    private long a = 20000;
    private String e = "GET";

    public RunnableC0135dj(RunnableC0134di runnableC0134di, String str) {
        this.b = runnableC0134di;
        this.g = str;
    }

    private synchronized long j() {
        return this.a;
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized void a(long j) {
        this.a = j;
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized void a(InputStream inputStream) {
        this.d = inputStream;
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized void a(String str) {
        this.e = str;
    }

    @Override // defpackage.AbstractC0132dg, defpackage.InterfaceC0133dh
    public final synchronized void b() {
        if (d_()) {
            dA.a(this.h);
            dA.a(this.c);
            super.b();
        }
    }

    @Override // defpackage.InterfaceC0137dl
    public final void b(dX dXVar) {
        a(dXVar);
        this.b.a(this);
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized void b(String str) {
        this.f = str;
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized int b_() {
        a();
        return this.k;
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized long e() {
        a();
        return this.j;
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized String f() {
        a();
        return this.i;
    }

    @Override // defpackage.InterfaceC0133dh
    public final synchronized DataInputStream g() {
        a();
        return this.h;
    }

    public final synchronized void i() {
        if (c_() == 1) {
            a(new C0138dm());
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataOutputStream dataOutputStreamA;
        InterfaceC0146dv interfaceC0146dv;
        InputStream inputStream;
        C0136dk c0136dk = new C0136dk(this.b.c);
        c0136dk.a = this;
        c0136dk.a(j());
        c0136dk.e();
        try {
            try {
                synchronized (this) {
                    e_();
                    this.c = this.b.e.a(this.g, this.e.equals("POST"));
                    if (this.f != null) {
                        this.c.a("Content-Type", this.f);
                    }
                    dataOutputStreamA = this.d != null ? this.c.a() : null;
                    interfaceC0146dv = this.c;
                    inputStream = this.d;
                }
                if (inputStream != null) {
                    try {
                        dA.a(inputStream, dataOutputStreamA);
                        dA.a(dataOutputStreamA);
                    } catch (Throwable th) {
                        dA.a(dataOutputStreamA);
                        throw th;
                    }
                }
                int iC = interfaceC0146dv.c();
                long jE = interfaceC0146dv.e();
                String strD = interfaceC0146dv.d();
                DataInputStream dataInputStreamB = interfaceC0146dv.b();
                if (iC == 200) {
                    this.b.e.a(true);
                }
                synchronized (this) {
                    if (c_() == 1) {
                        this.k = iC;
                        this.j = jE;
                        this.i = strD;
                        this.h = dataInputStreamB;
                        h();
                    }
                }
                c0136dk.b();
            } catch (Exception e) {
                synchronized (this) {
                    if (c_() == 1) {
                        a(e);
                    }
                    c_();
                    c0136dk.b();
                }
            }
        } catch (Throwable th2) {
            c0136dk.b();
            throw th2;
        }
    }
}
