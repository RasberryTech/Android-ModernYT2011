package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class eF extends eQ {
    private InterfaceC0170es a;
    private String b;
    private String c;
    private Hashtable d;
    private byte[] e;
    private byte[] f;
    private byte[] g;

    public eF() {
        this.b = "GET";
        c(256);
    }

    public eF(String str, int i) {
        super(str, 1);
        this.b = "GET";
        c(256);
    }

    private void l() throws IOException {
        if (this.f == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeUTF(this.b);
            eH.a(dataOutputStream, this.d, this.c);
            if (this.a != null) {
                dataOutputStream.writeInt(this.a.a());
            } else {
                dataOutputStream.writeInt(0);
            }
            dataOutputStream.close();
            byteArrayOutputStream.close();
            this.f = byteArrayOutputStream.toByteArray();
            byte[] bArr = this.f;
        }
        if (this.e == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream2.writeShort(c());
            dataOutputStream2.writeUTF(j());
            dataOutputStream2.writeShort(k());
            int length = this.f.length;
            if (this.a != null) {
                length += this.a.a();
            }
            dataOutputStream2.writeInt(length);
            dataOutputStream2.close();
            byteArrayOutputStream2.close();
            this.e = byteArrayOutputStream2.toByteArray();
            byte[] bArr2 = this.e;
        }
    }

    @Override // defpackage.eB
    public final synchronized void a(int i) {
        super.a(i);
        this.e = null;
    }

    public final synchronized void a(String str) {
        this.b = str;
    }

    public final synchronized void a(String str, String str2) {
        if ("Content-Type".toLowerCase().equals(str.toLowerCase())) {
            this.c = str2;
        } else {
            if (this.d == null) {
                this.d = new Hashtable();
            }
            this.d.put(str, str2);
        }
    }

    public final synchronized void a(byte[] bArr) {
        this.a = new C0167ep(bArr);
    }

    @Override // defpackage.eQ, defpackage.eN
    public final synchronized void f() {
        this.e = null;
        this.f = null;
        this.g = null;
    }

    @Override // defpackage.eQ
    public final synchronized int g() {
        int length;
        l();
        length = this.e.length + 0 + this.f.length;
        if (this.a != null) {
            length += this.a.a();
        }
        return length;
    }

    @Override // defpackage.eQ
    public final synchronized InputStream h() {
        InputStream[] inputStreamArr;
        l();
        Vector vector = new Vector();
        vector.addElement(new ByteArrayInputStream(this.e));
        vector.addElement(new ByteArrayInputStream(this.f));
        if (this.a != null) {
            vector.addElement(this.a.b());
        }
        inputStreamArr = new InputStream[vector.size()];
        vector.copyInto(inputStreamArr);
        return new dF(inputStreamArr);
    }
}
