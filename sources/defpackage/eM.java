package defpackage;

import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class eM {
    private DataInputStream a;
    private C0169er b;

    public eM(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream;
        if (dataInputStream.readUnsignedShort() != 2) {
            throw new IOException("Unrecognised protocol version");
        }
    }

    public final void a() {
        if (this.b != null) {
            this.b = null;
        }
        this.a.close();
        this.a = null;
    }

    public final eP b() throws IOException {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        int i = this.a.readInt();
        int unsignedShort = this.a.readUnsignedShort();
        if (unsignedShort == 33024) {
            this.b = new C0169er(this.a, i);
            return new eL(this.b);
        }
        if (unsignedShort == 33025) {
            this.b = new C0169er(this.a, i);
            return new eI(this.b);
        }
        this.a.skipBytes(i);
        return null;
    }
}
