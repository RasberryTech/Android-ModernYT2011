package defpackage;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class eP extends eB implements InterfaceC0170es {
    private C0169er a;
    private int b;

    public eP(int i, int i2) {
        a(i);
        this.b = i2;
    }

    public eP(C0169er c0169er) throws IOException {
        this.a = c0169er;
        DataInputStream dataInputStream = new DataInputStream(c0169er);
        try {
            a(dataInputStream.readUnsignedShort());
            this.b = dataInputStream.readUnsignedShort();
        } catch (IOException e) {
            throw e;
        }
    }

    public abstract int a();

    public abstract InputStream b();

    public final void f() {
    }

    public final int g() {
        return this.b;
    }

    public final void h() {
        if (this.a != null) {
            this.a.b();
        }
    }
}
