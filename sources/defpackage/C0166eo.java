package defpackage;

/* JADX INFO: renamed from: eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0166eo {
    private final byte[] b;
    private int d;
    private boolean e;
    private final Object a = new Object();
    private int c = -1;

    public C0166eo(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSize " + i);
        }
        this.b = new byte[i];
    }

    public final int a() {
        synchronized (this.a) {
            while (this.c < 0) {
                if (this.e) {
                    return -1;
                }
                try {
                    this.a.wait();
                } catch (InterruptedException e) {
                }
            }
            byte[] bArr = this.b;
            int i = this.c;
            this.c = i + 1;
            int i2 = bArr[i] & 255;
            if (this.c == this.b.length) {
                this.c = 0;
            }
            if (this.c == this.d) {
                this.c = -1;
                this.d = 0;
            }
            this.a.notifyAll();
            return i2;
        }
    }

    public final int a(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        int i4;
        int i5;
        if (i2 == 0) {
            return 0;
        }
        synchronized (this.a) {
            while (this.c < 0) {
                if (this.e) {
                    return -1;
                }
                try {
                    this.a.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.c < this.d) {
                length = this.d - this.c;
                i3 = 0;
                i4 = i;
                i5 = i2;
            } else {
                length = this.b.length - this.c;
                if (length < i2) {
                    System.arraycopy(this.b, this.c, bArr, i, length);
                    int i6 = i + length;
                    i5 = i2 - length;
                    int i7 = this.d;
                    this.c = 0;
                    i4 = i6;
                    i3 = length;
                    length = i7;
                } else {
                    i3 = 0;
                    i4 = i;
                    i5 = i2;
                }
            }
            if (length > i5) {
                length = i5;
            }
            System.arraycopy(this.b, this.c, bArr, i4, length);
            int i8 = i3 + length;
            this.c = length + this.c;
            if (this.c == this.b.length) {
                this.c = 0;
            }
            if (this.c == this.d) {
                this.c = -1;
                this.d = 0;
            }
            this.a.notifyAll();
            return i8;
        }
    }

    public final void a(byte[] bArr, int i) {
        int i2 = 0;
        synchronized (this.a) {
            int i3 = i;
            while (i3 > 0) {
                while (this.c == this.d) {
                    try {
                        this.a.notifyAll();
                        this.a.wait();
                    } catch (InterruptedException e) {
                    }
                }
                if (this.c < 0) {
                    this.c = 0;
                }
                int length = this.d < this.c ? this.c - this.d : this.b.length - this.d;
                if (length > i3) {
                    length = i3;
                }
                System.arraycopy(bArr, i2, this.b, this.d, length);
                i2 += length;
                i3 -= length;
                this.d = length + this.d;
                if (this.d == this.b.length) {
                    this.d = 0;
                }
            }
            this.a.notifyAll();
        }
    }

    public final void b() {
        synchronized (this.a) {
            this.e = true;
            this.a.notifyAll();
        }
    }
}
