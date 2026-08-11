package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class dF extends InputStream {
    private InputStream[] a;
    private int b;

    public dF(InputStream inputStream, InputStream inputStream2) {
        this(new InputStream[]{inputStream, inputStream2});
    }

    public dF(InputStream inputStream, InputStream inputStream2, InputStream inputStream3) {
        this(new InputStream[]{inputStream, inputStream2, inputStream3});
    }

    public dF(InputStream[] inputStreamArr) {
        this.a = null;
        this.b = 0;
        this.a = inputStreamArr;
    }

    private InputStream a() {
        if (this.a == null || this.b >= this.a.length) {
            return null;
        }
        return this.a[this.b];
    }

    private void b() {
        if (this.a == null || this.b >= this.a.length) {
            return;
        }
        try {
            this.a[this.b].close();
        } catch (IOException e) {
        }
        InputStream[] inputStreamArr = this.a;
        int i = this.b;
        this.b = i + 1;
        inputStreamArr[i] = null;
        if (this.b >= this.a.length) {
            this.a = null;
        }
    }

    @Override // java.io.InputStream
    public final synchronized int available() {
        InputStream inputStreamA;
        inputStreamA = a();
        return inputStreamA != null ? inputStreamA.available() : 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.a != null) {
            boolean z = false;
            while (this.b < this.a.length) {
                try {
                    this.a[this.b].close();
                } catch (IOException e) {
                    z = true;
                }
                this.b++;
            }
            this.a = null;
            if (z) {
                throw new IOException();
            }
        }
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        int i;
        while (true) {
            InputStream inputStreamA = a();
            if (inputStreamA != null) {
                i = inputStreamA.read();
                if (i != -1) {
                    break;
                }
                b();
            } else {
                i = -1;
                break;
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        try {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i2 == 0) {
                i3 = 0;
            } else {
                if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                if (this.a == null || this.b >= this.a.length) {
                    i3 = -1;
                } else if (i2 == 0) {
                    i3 = 0;
                } else {
                    i3 = 0;
                    int i4 = i2;
                    int i5 = i;
                    while (i4 > 0) {
                        InputStream inputStreamA = a();
                        if (inputStreamA == null) {
                            break;
                        }
                        int i6 = inputStreamA.read(bArr, i5, i4);
                        if (i6 != -1) {
                            i5 += i6;
                            i4 -= i6;
                            i3 += i6;
                        } else {
                            b();
                        }
                    }
                    if (i3 == 0) {
                        i3 = -1;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public final synchronized long skip(long j) {
        long j2;
        InputStream inputStreamA;
        if (this.a == null || this.b >= this.a.length || j <= 0) {
            j2 = 0;
        } else {
            j2 = 0;
            long j3 = j;
            while (j3 > 0 && (inputStreamA = a()) != null) {
                long jSkip = inputStreamA.skip(j3);
                if (jSkip != 0) {
                    j3 -= jSkip;
                    j2 += jSkip;
                } else if (inputStreamA.read() == -1) {
                    b();
                } else {
                    j3--;
                    j2++;
                }
            }
        }
        return j2;
    }
}
