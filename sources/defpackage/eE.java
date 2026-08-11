package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class eE extends eN {
    private String a;
    private String b;
    private byte[] c;

    public eE(String str, String str2, String str3, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(',');
        stringBuffer.append(str2);
        stringBuffer.append(',');
        stringBuffer.append(str3);
        stringBuffer.append(',');
        stringBuffer.append(str4);
        stringBuffer.append(',');
        stringBuffer.append("en_US");
        this.b = stringBuffer.toString();
        this.a = str5;
    }

    private byte[] g() throws IOException {
        byte[] bArr;
        synchronized (this) {
            bArr = this.c;
        }
        if (bArr == null) {
            long jB = eR.a().b();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(2);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeUTF(this.b);
            dataOutputStream.writeLong(jB);
            dataOutputStream.writeUTF(this.a);
            dataOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            synchronized (this) {
                if (this.c != null) {
                    bArr = this.c;
                } else if (jB != 0) {
                    this.c = byteArray;
                    bArr = byteArray;
                } else {
                    bArr = byteArray;
                }
            }
        }
        return bArr;
    }

    @Override // defpackage.eN, defpackage.InterfaceC0170es
    public final int a() {
        return g().length;
    }

    @Override // defpackage.eN, defpackage.InterfaceC0170es
    public final InputStream b() {
        return new ByteArrayInputStream(g());
    }

    @Override // defpackage.eN
    public final long d() {
        throw new RuntimeException();
    }

    @Override // defpackage.eN
    public final boolean e() {
        throw new RuntimeException();
    }

    @Override // defpackage.eN
    public final void f() {
    }
}
