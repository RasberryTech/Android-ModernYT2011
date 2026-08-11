package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class dB extends OutputStream {
    private byte[] a = new byte[16];
    private int[] b = new int[1];
    private int c;
    private int d;

    public dB() {
        this.c = 0;
        this.d = 0;
        this.c = 0;
        this.d = 0;
    }

    private static int a(int i, int i2, int i3) {
        int i4 = i2 - i3;
        int i5 = i2;
        while (i4 < i) {
            i4 += i5;
            i5 <<= 1;
        }
        return i5;
    }

    private void c(int i) {
        int iA = a(i, this.a.length, this.c);
        if (iA > this.a.length) {
            byte[] bArr = new byte[iA];
            System.arraycopy(this.a, 0, bArr, 0, this.c);
            this.a = bArr;
        }
    }

    public final int a() {
        return this.d;
    }

    public final int a(int i) {
        return this.b[i];
    }

    public final void a(int i, int i2) {
        this.b[i] = i2;
    }

    public final void a(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.a, i, i2);
    }

    public final int b() {
        return this.c;
    }

    public final void b(int i) {
        int iA = a(1, this.b.length, this.d);
        if (iA > this.b.length) {
            int[] iArr = new int[iA];
            System.arraycopy(this.b, 0, iArr, 0, this.d);
            this.b = iArr;
        }
        int[] iArr2 = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        iArr2[i2] = i;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        c(1);
        byte[] bArr = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        c(bArr.length);
        System.arraycopy(bArr, 0, this.a, this.c, bArr.length);
        this.c += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        c(i2);
        System.arraycopy(bArr, i, this.a, this.c, i2);
        this.c += i2;
    }
}
