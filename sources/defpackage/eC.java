package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class eC implements InterfaceC0170es {
    private final InterfaceC0170es a;
    private Hashtable b;
    private String c;
    private String d;
    private byte[] e;

    private eC(String str, InterfaceC0170es interfaceC0170es) {
        this.c = str;
        this.a = interfaceC0170es;
    }

    public static eC a(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        short s = dataInputStream.readShort();
        String utf = dataInputStream.readUTF();
        if (utf.length() == 0) {
            utf = eH.a(s);
        }
        String utf2 = dataInputStream.readUTF();
        Hashtable hashtableA = eH.a(dataInputStream);
        Enumeration enumerationKeys = hashtableA.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            System.out.println(str + " => " + ((String) hashtableA.get(str)));
        }
        int i = dataInputStream.readInt();
        String utf3 = dataInputStream.readUTF();
        C0169er c0169er = new C0169er(dataInputStream, i);
        eD eDVar = new eD(utf3, -1, c0169er);
        c0169er.b();
        eC eCVar = new eC(utf, eDVar);
        eCVar.b = hashtableA;
        eCVar.d = utf2;
        return eCVar;
    }

    private synchronized void e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        eH.a(dataOutputStream, this.c);
        dataOutputStream.writeUTF(f());
        eH.a(dataOutputStream, d(), null);
        dataOutputStream.writeInt(this.a.a());
        if (this.a.a() > 0) {
            dataOutputStream.writeUTF("");
        }
        dataOutputStream.close();
        byteArrayOutputStream.close();
        this.e = byteArrayOutputStream.toByteArray();
    }

    private synchronized String f() {
        return this.d != null ? this.d : "";
    }

    @Override // defpackage.InterfaceC0170es
    public final int a() {
        e();
        return this.e.length + this.a.a();
    }

    @Override // defpackage.InterfaceC0170es
    public final InputStream b() {
        e();
        return new dF(new ByteArrayInputStream(this.e), this.a.b());
    }

    public final InterfaceC0170es c() {
        return this.a;
    }

    public final synchronized Hashtable d() {
        if (this.b == null) {
            this.b = new Hashtable();
        }
        return this.b;
    }
}
