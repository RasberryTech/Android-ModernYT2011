package defpackage;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class eI extends eP {
    private final eC a;
    private final eC[] b;
    private final int c;

    public eI(int i, int i2, eC eCVar, eC[] eCVarArr) {
        super(i, i2);
        this.a = eCVar;
        this.b = eCVarArr;
        this.c = eCVarArr.length;
    }

    public eI(C0169er c0169er) throws IOException {
        super(c0169er);
        DataInputStream dataInputStream = new DataInputStream(c0169er);
        try {
            this.a = eC.a(dataInputStream);
            this.c = dataInputStream.readShort();
            this.b = new eC[this.c];
            for (int i = 0; i < this.c; i++) {
                this.b[i] = eC.a(dataInputStream);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // defpackage.eP, defpackage.InterfaceC0170es
    public final int a() {
        return this.a.c().a();
    }

    @Override // defpackage.eP, defpackage.InterfaceC0170es
    public final InputStream b() {
        return this.a.c().b();
    }

    public final eC d() {
        return this.a;
    }

    public final eC[] e() {
        return this.b;
    }
}
