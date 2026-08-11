package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class dE {
    private final dC a;
    private Hashtable b = null;
    private boolean c = false;

    public dE(dC dCVar) {
        this.a = dCVar;
    }

    private static Hashtable a(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        Hashtable hashtable = new Hashtable();
        try {
            int unsignedShort = dataInputStream.readUnsignedShort();
            for (int i = 0; i < unsignedShort; i++) {
                String utf = dataInputStream.readUTF();
                byte[] bArr2 = new byte[dataInputStream.readUnsignedShort()];
                dataInputStream.readFully(bArr2);
                hashtable.put(utf, bArr2);
            }
        } catch (IOException e) {
            C0126da.a("FLASH", e);
        }
        return hashtable;
    }

    private synchronized void b() {
        if (this.b == null) {
            byte[] bArrB = this.a.b("Preferences");
            if (bArrB != null) {
                this.b = a(bArrB);
            } else {
                this.a.a(new byte[2000], "Preferences");
                this.b = new Hashtable();
            }
            this.c = false;
        }
    }

    public final synchronized void a() {
        if (this.c) {
            try {
                Hashtable hashtable = this.b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeShort(hashtable.size());
                Enumeration enumerationKeys = hashtable.keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str = (String) enumerationKeys.nextElement();
                    byte[] bArr = (byte[]) hashtable.get(str);
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    dataOutputStream.writeUTF(str);
                    dataOutputStream.writeShort(bArr.length);
                    dataOutputStream.write(bArr);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray.length <= 2000) {
                    byte[] bArr2 = new byte[2000];
                    System.arraycopy(byteArray, 0, bArr2, 0, byteArray.length);
                    byteArray = bArr2;
                }
                this.a.a(byteArray, "Preferences");
            } catch (IOException e) {
                C0126da.a("FLASH", e);
            }
            this.c = false;
        }
    }

    public final synchronized boolean a(String str, byte[] bArr) {
        boolean z;
        b();
        this.c = true;
        if (bArr == null) {
            z = this.b.remove(str) != null;
        } else {
            this.b.put(str, bArr);
            z = true;
        }
        return z;
    }

    public final synchronized byte[] a(String str) {
        b();
        return (byte[]) this.b.get(str);
    }
}
