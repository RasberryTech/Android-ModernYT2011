package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: renamed from: en, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0165en extends AbstractC0155ed implements InterfaceC0146dv, eO {
    private eF a;
    private ByteArrayOutputStream b;
    private Exception c;
    private DataInputStream d;
    private String[] e;
    private String[] f;
    private int g;
    private int h;
    private int i = 0;

    public C0165en(String str, boolean z) {
        String str2 = "AsyncHttpConnection(" + str + ", " + z + ")";
        this.a = new eF(str, 1);
        this.a.a(this);
        if (!z) {
            this.a.a("GET");
        } else {
            this.a.a("POST");
            this.a.b(0);
        }
    }

    private void a(int i) {
        String str = "AsyncHttpConnection.setState(" + i + ")";
        this.i = i;
        g();
    }

    private synchronized void a(boolean z) {
        if (this.i == 0) {
            if (this.b != null) {
                this.a.a(this.b.toByteArray());
            }
            C0171et.b().a((eN) this.a, true);
            a(1);
        }
    }

    private void l() throws IOException {
        if (this.i == 3) {
            throw new IOException("connection closed");
        }
    }

    private void m() throws IOException {
        if (this.c == null) {
            return;
        }
        if (this.c instanceof IOException) {
            throw ((IOException) this.c);
        }
        if (this.c instanceof RuntimeException) {
            throw ((RuntimeException) this.c);
        }
    }

    @Override // defpackage.InterfaceC0146dv
    public final synchronized DataOutputStream a() {
        if (this.b == null) {
            this.b = new ByteArrayOutputStream();
        }
        return new DataOutputStream(this.b);
    }

    public synchronized String a(String str) {
        String str2;
        String str3 = "AsyncHttpConnection.getHeaderField(\"" + str + "\")";
        l();
        m();
        if (this.e != null) {
            for (int i = 0; i < this.e.length; i++) {
                if (this.e[i].toLowerCase().equals(str.toLowerCase())) {
                    str2 = this.f[i];
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        return str2;
    }

    @Override // defpackage.eO
    public final synchronized void a(eN eNVar, eP ePVar) {
        int i;
        try {
            if (this.i == 1) {
                eG eGVar = new eG(ePVar);
                this.g = eGVar.a();
                this.e = eGVar.d();
                this.f = eGVar.e();
                this.h = eGVar.b();
                this.d = eGVar.c();
                i = 2;
            }
        } catch (IOException e) {
            this.c = e;
            i = 2;
        } catch (RuntimeException e2) {
            this.c = e2;
            i = 2;
        } finally {
            a(2);
        }
    }

    @Override // defpackage.eO
    public final synchronized void a(eN eNVar, Exception exc) {
        this.c = exc;
        a(2);
    }

    @Override // defpackage.InterfaceC0146dv
    public final synchronized void a(String str, String str2) {
        this.a.a(str, str2);
    }

    @Override // defpackage.InterfaceC0146dv
    public synchronized DataInputStream b() {
        l();
        m();
        return this.d != null ? this.d : null;
    }

    @Override // defpackage.InterfaceC0146dv
    public synchronized int c() {
        l();
        m();
        return this.g;
    }

    @Override // defpackage.InterfaceC0146dv
    public synchronized String d() {
        l();
        m();
        return a("content-type");
    }

    @Override // defpackage.InterfaceC0146dv
    public synchronized long e() {
        l();
        m();
        return this.h;
    }

    @Override // defpackage.InterfaceC0146dv
    public final synchronized void f() {
        dA.a(this.b);
        this.b = null;
        this.a = null;
        dA.a(this.d);
        this.d = null;
        this.e = null;
        this.f = null;
        a(3);
    }

    public final synchronized boolean h() {
        return this.i == 0;
    }

    public final synchronized boolean i() {
        return this.i == 2;
    }

    public final synchronized boolean j() {
        return this.i == 3;
    }

    public final synchronized void k() {
        a(true);
    }
}
