package defpackage;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class eD implements InterfaceC0170es {
    private C0169er a;
    private int b;

    public eD(String str, int i, C0169er c0169er) {
        if (i > 0) {
            this.b = i;
        } else {
            this.b = 0;
        }
        if (str != null) {
            int length = str.length();
            InputStream inputStreamA = c0169er;
            while (length > 0) {
                int i2 = length - 1;
                length = str.lastIndexOf(44, i2);
                String strSubstring = str.substring(length + 1, i2 + 1);
                if (strSubstring.equals("g")) {
                    inputStreamA = C0147dw.a(inputStreamA);
                } else if (!strSubstring.equals("n")) {
                    throw new IllegalArgumentException("unrecognised encoding: " + strSubstring);
                }
            }
            if (i > 0) {
                this.a = new C0169er(inputStreamA, this.b);
            } else {
                this.a = new C0169er(inputStreamA, Integer.MAX_VALUE);
            }
        }
    }

    @Override // defpackage.InterfaceC0170es
    public final int a() {
        return this.b;
    }

    @Override // defpackage.InterfaceC0170es
    public final InputStream b() {
        return this.a;
    }
}
