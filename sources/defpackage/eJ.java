package defpackage;

import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class eJ {
    private eC a;
    private Vector b = new Vector();
    private int c;
    private int d;

    public eJ(int i, int i2, eC eCVar) {
        this.c = i;
        this.d = i2;
        this.a = eCVar;
    }

    public final eI a() {
        eC[] eCVarArr = new eC[this.b.size()];
        this.b.copyInto(eCVarArr);
        return new eI(this.c, this.d, this.a, eCVarArr);
    }

    public final void a(eC eCVar) {
        this.b.addElement(eCVar);
    }
}
