package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class eK extends eQ {
    private InterfaceC0170es a;
    private byte[] b;

    public eK(String str, int i) {
        super(str, 0);
        c(256);
    }

    private eK(String str, int i, InterfaceC0170es interfaceC0170es) {
        super(str, i);
        c(256);
        this.a = interfaceC0170es;
    }

    public eK(String str, int i, byte[] bArr) {
        this(str, i, new C0167ep(bArr));
    }

    private void l() throws IOException {
        if (this.b == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(c());
            dataOutputStream.writeUTF(j());
            dataOutputStream.writeShort(k());
            if (this.a != null) {
                dataOutputStream.writeInt(this.a.a());
            } else {
                dataOutputStream.writeInt(0);
            }
            dataOutputStream.close();
            byteArrayOutputStream.close();
            this.b = byteArrayOutputStream.toByteArray();
        }
    }

    @Override // defpackage.eB
    public final synchronized void a(int i) {
        super.a(i);
        this.b = null;
    }

    @Override // defpackage.eQ, defpackage.eN
    public final synchronized void f() {
        super.f();
        this.b = null;
    }

    @Override // defpackage.eQ
    protected final synchronized int g() {
        int length;
        l();
        length = this.b.length;
        if (this.a != null) {
            length += this.a.a();
        }
        return length;
    }

    @Override // defpackage.eQ
    protected final synchronized InputStream h() {
        l();
        return this.a == null ? new ByteArrayInputStream(this.b) : new dF(new ByteArrayInputStream(this.b), this.a.b());
    }
}
