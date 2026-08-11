package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class eZ extends eQ {
    private C0179fa a;
    private String b;
    private Hashtable c;
    private int d;
    private byte[] f;
    private byte[] g;
    private byte[] h;
    private int e = 0;
    private short i = 0;

    public eZ() {
        c(256);
    }

    private void m() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(c());
        dataOutputStream.writeUTF("g:rsm");
        dataOutputStream.writeShort(this.i);
        if (this.h == null) {
            dataOutputStream.writeInt(this.g.length);
        } else {
            dataOutputStream.writeInt(this.g.length + this.h.length);
        }
        dataOutputStream.close();
        byteArrayOutputStream.close();
        this.f = byteArrayOutputStream.toByteArray();
    }

    private void n() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        if (this.b != null) {
            dataOutputStream.writeUTF(this.b);
        } else {
            dataOutputStream.writeUTF("");
        }
        if (this.c == null) {
            dataOutputStream.writeByte(0);
        } else {
            dataOutputStream.writeByte(this.c.size());
            Enumeration enumerationKeys = this.c.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str = (String) enumerationKeys.nextElement();
                String str2 = (String) this.c.get(str);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
            }
        }
        dataOutputStream.writeInt(this.d);
        if (this.i > 0) {
            dataOutputStream.writeByte(this.e);
        }
        if (this.h == null) {
            dataOutputStream.writeInt(0);
        } else {
            dataOutputStream.writeInt(this.h.length);
        }
        dataOutputStream.close();
        byteArrayOutputStream.close();
        this.g = byteArrayOutputStream.toByteArray();
    }

    @Override // defpackage.eB
    public final synchronized void a(int i) {
        super.a(i);
        this.f = null;
    }

    public final synchronized void a(int i, byte[] bArr) {
        String str = "ResumeServiceRequest.setPayload(" + i + ", " + bArr + ")";
        this.d = i;
        this.h = bArr;
    }

    public final synchronized void a(C0179fa c0179fa) {
        String str = "ResumeServiceRequest.setResponse(" + c0179fa + ")";
        this.a = c0179fa;
    }

    public final synchronized void a(String str) {
        String str2 = "ResumeServiceRequest.setServerTicket(" + str + ")";
        this.b = str;
    }

    public final synchronized void a(String str, String str2) {
        String str3 = "ResumeServiceRequest.setProperty(\"" + str + "\", " + str2 + ")";
        if (this.c == null) {
            this.c = new Hashtable();
        }
        this.c.put(str, str2);
    }

    public final synchronized void d(int i) {
        String str = "ResumeServiceRequest.setRequestType(" + i + ")";
        if (i == 0) {
            this.i = (short) 0;
        } else {
            this.i = (short) 1;
        }
        this.e = i;
    }

    @Override // defpackage.eQ, defpackage.eN
    public final synchronized void f() {
        super.f();
        this.f = null;
        this.g = null;
    }

    @Override // defpackage.eQ
    protected final synchronized int g() {
        int length;
        if (this.g == null) {
            n();
        }
        if (this.f == null) {
            m();
        }
        length = this.f.length + 0 + this.g.length;
        if (this.h != null) {
            length += this.h.length;
        }
        return length;
    }

    @Override // defpackage.eQ
    protected final synchronized InputStream h() {
        if (this.g == null) {
            n();
        }
        if (this.f == null) {
            m();
        }
        return this.h == null ? new dF(new ByteArrayInputStream(this.f), new ByteArrayInputStream(this.g)) : new dF(new ByteArrayInputStream(this.f), new ByteArrayInputStream(this.g), new ByteArrayInputStream(this.h));
    }

    public final synchronized C0179fa l() {
        return this.a;
    }
}
