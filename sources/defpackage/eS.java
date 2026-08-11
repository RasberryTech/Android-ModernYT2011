package defpackage;

import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class eS implements eO {
    private /* synthetic */ eR a;

    eS(eR eRVar) {
        this.a = eRVar;
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, eP ePVar) {
        synchronized (eR.a()) {
            try {
                try {
                    int iG = ePVar.g();
                    ePVar.a();
                    if (iG == 200) {
                        DataInputStream dataInputStream = new DataInputStream(ePVar.b());
                        this.a.b = dataInputStream.readLong();
                        eR.a(this.a, false);
                    } else {
                        this.a.b = 0L;
                    }
                    eR.b(this.a, false);
                    this.a.e();
                } catch (IOException e) {
                    this.a.b = 0L;
                    eR.b(this.a, false);
                    this.a.e();
                }
            } catch (Throwable th) {
                eR.b(this.a, false);
                this.a.e();
                throw th;
            }
        }
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, Exception exc) {
        synchronized (eR.a()) {
            eR.b(this.a, false);
        }
    }
}
