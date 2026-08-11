package defpackage;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class gA {
    private final byte[] a;
    private final int b;
    private int c;
    private final OutputStream d = null;

    private gA(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i + i2;
    }

    public static gA a(byte[] bArr) {
        return new gA(bArr, 0, bArr.length);
    }

    public final void a(int i, boolean z) throws gB {
        a(i, 0);
        a(z ? 1 : 0);
    }

    public final void a(int i, String str) throws gB, UnsupportedEncodingException {
        a(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        c(bytes.length);
        int length = bytes.length;
        if (this.b - this.c >= length) {
            System.arraycopy(bytes, 0, this.a, this.c, length);
            this.c += length;
            return;
        }
        int i2 = this.b - this.c;
        System.arraycopy(bytes, 0, this.a, this.c, i2);
        int i3 = i2 + 0;
        int i4 = length - i2;
        this.c = this.b;
        throw new gB();
    }

    public final void a(int i, gG gGVar) throws gB {
        a(i, 2);
        c(gGVar.j());
        gGVar.a(this);
    }

    public static int b(int i, boolean z) {
        return b(i) + 1;
    }

    public static int b(int i, String str) {
        return b(i) + a(str);
    }

    public static int b(int i, gG gGVar) {
        int iB = b(i);
        int iJ = gGVar.j();
        return iB + iJ + d(iJ);
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + d(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public final void a() {
        if (this.b - this.c != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void a(int i) throws gB {
        byte b = (byte) i;
        if (this.c == this.b) {
            throw new gB();
        }
        byte[] bArr = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr[i2] = b;
    }

    public final void a(int i, int i2) throws gB {
        c(gJ.a(i, i2));
    }

    public static int b(int i) {
        return d(gJ.a(i, 0));
    }

    public final void c(int i) throws gB {
        int i2 = i;
        while ((i2 & (-128)) != 0) {
            a((i2 & 127) | 128);
            i2 >>>= 7;
        }
        a(i2);
    }

    public static int d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }
}
