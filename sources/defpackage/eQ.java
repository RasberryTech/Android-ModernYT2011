package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class eQ extends eN {
    private String a;
    private int b;
    private int c;
    private byte[] d;

    protected eQ() {
    }

    protected eQ(String str, int i) {
        a(str);
        d(i);
    }

    private synchronized void a(String str) {
        this.a = str;
    }

    private synchronized void d(int i) {
        this.b = i;
    }

    private byte[] l() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(7);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(g());
        dataOutputStream.writeByte(0);
        dataOutputStream.writeShort(this.c);
        dataOutputStream.close();
        byteArrayOutputStream.close();
        this.d = byteArrayOutputStream.toByteArray();
        return this.d;
    }

    @Override // defpackage.eN, defpackage.InterfaceC0170es
    public final synchronized int a() {
        l();
        return this.d.length + g();
    }

    @Override // defpackage.eN, defpackage.InterfaceC0170es
    public final synchronized InputStream b() {
        l();
        return new dF(new ByteArrayInputStream(this.d), h());
    }

    public final synchronized void c(int i) {
        this.c = 256;
    }

    @Override // defpackage.eN
    public synchronized void f() {
        this.d = null;
    }

    protected abstract int g();

    protected abstract InputStream h();

    public final synchronized String j() {
        return this.a;
    }

    public final synchronized int k() {
        return this.b;
    }
}
