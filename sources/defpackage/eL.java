package defpackage;

import java.io.DataInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class eL extends eP {
    private eD a;

    public eL(C0169er c0169er) {
        super(c0169er);
        DataInputStream dataInputStream = new DataInputStream(c0169er);
        this.a = new eD(dataInputStream.readUTF(), dataInputStream.readInt(), c0169er);
    }

    @Override // defpackage.eP, defpackage.InterfaceC0170es
    public final int a() {
        return this.a.a();
    }

    @Override // defpackage.eP, defpackage.InterfaceC0170es
    public final InputStream b() {
        return this.a.b();
    }
}
