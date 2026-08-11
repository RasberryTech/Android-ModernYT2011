package defpackage;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class eG {
    private DataInputStream a;
    private String[] b;
    private String[] c;
    private int d;
    private int e;
    private int f;

    public eG(eP ePVar) throws IOException {
        int i = 0;
        this.f = ePVar.g();
        this.e = ePVar.a();
        this.a = new DataInputStream(ePVar.b());
        if (ePVar instanceof eI) {
            Hashtable hashtableD = ((eI) ePVar).d().d();
            this.d = hashtableD.size();
            this.b = new String[this.d];
            this.c = new String[this.d];
            Enumeration enumerationKeys = hashtableD.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str = (String) enumerationKeys.nextElement();
                this.b[i] = str;
                this.c[i] = (String) hashtableD.get(str);
                i++;
            }
            return;
        }
        if (this.e > 0) {
            this.d = this.a.readByte() & 255;
            this.e--;
            if (this.d > 0) {
                this.b = new String[this.d];
                this.c = new String[this.d];
                for (int i2 = 0; i2 < this.d; i2++) {
                    String utf = this.a.readUTF();
                    this.b[i2] = utf;
                    this.e -= utf.length() + 2;
                    String utf2 = this.a.readUTF();
                    this.c[i2] = utf2;
                    this.e -= utf2.length() + 2;
                }
            }
        }
    }

    public final int a() {
        return this.f;
    }

    public final int b() {
        return this.e;
    }

    public final DataInputStream c() {
        return this.a;
    }

    public final String[] d() {
        return this.b;
    }

    public final String[] e() {
        return this.c;
    }
}
