package defpackage;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class fD implements Serializable {
    private final ArrayList a;

    /* synthetic */ fD() {
        this((byte) 0);
    }

    private fD(byte b) {
        this.a = new ArrayList();
    }

    public final String a(int i) {
        int size = this.a.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = i2 + ((size - i2) / 2);
            fF fFVar = (fF) this.a.get(i3);
            if (i < fFVar.b) {
                size = i3 - 1;
            } else if (i > fFVar.c) {
                i2 = i3 + 1;
            } else {
                return fFVar.a;
            }
        }
        return null;
    }
}
