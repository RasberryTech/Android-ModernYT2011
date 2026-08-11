package defpackage;

import com.google.android.youtube.player.YouTubePlayer;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class gz {
    private int c;
    private final InputStream e;
    private int f;
    private int i;
    private int h = Integer.MAX_VALUE;
    private int j = 64;
    private int k = 67108864;
    private final byte[] a = new byte[4096];
    private int b = 0;
    private int d = 0;
    private int g = 0;

    public static gz a(InputStream inputStream) {
        return new gz(inputStream);
    }

    public final int a() throws gF {
        if (this.d == this.b && !a(false)) {
            this.f = 0;
            return 0;
        }
        this.f = e();
        if (gJ.b(this.f) == 0) {
            throw new gF("Protocol message contained an invalid tag (zero).");
        }
        return this.f;
    }

    public final void a(int i) throws gF {
        if (this.f != i) {
            throw new gF("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean b(int i) throws gF {
        int iA;
        switch (gJ.a(i)) {
            case 0:
                e();
                return true;
            case YouTubePlayer.PREPARED /* 1 */:
                byte bG = g();
                long j = ((long) bG) & 255;
                long jG = ((((long) g()) & 255) << 8) | j | ((((long) g()) & 255) << 16) | ((((long) g()) & 255) << 24) | ((((long) g()) & 255) << 32) | ((((long) g()) & 255) << 40) | ((((long) g()) & 255) << 48) | ((((long) g()) & 255) << 56);
                return true;
            case YouTubePlayer.PLAYING /* 2 */:
                d(e());
                return true;
            case YouTubePlayer.PAUSED /* 3 */:
                break;
            case YouTubePlayer.STOPPED /* 4 */:
                return false;
            case YouTubePlayer.PROGRESS /* 5 */:
                int iG = (g() & 255) | ((g() & 255) << 8) | ((g() & 255) << 16) | ((g() & 255) << 24);
                return true;
            default:
                throw new gF("Protocol message tag had invalid wire type.");
        }
        do {
            iA = a();
            if (iA != 0) {
            }
            a(gJ.a(gJ.b(i), 4));
            return true;
        } while (b(iA));
        a(gJ.a(gJ.b(i), 4));
        return true;
    }

    public final int b() {
        return e();
    }

    public final boolean c() {
        return e() != 0;
    }

    public final String d() throws gF {
        int iE = e();
        if (iE > this.b - this.d || iE <= 0) {
            return new String(c(iE), "UTF-8");
        }
        String str = new String(this.a, this.d, iE, "UTF-8");
        this.d = iE + this.d;
        return str;
    }

    public final void a(gH gHVar, gC gCVar) throws gF {
        int iE = e();
        if (this.i >= this.j) {
            throw new gF("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        if (iE < 0) {
            throw gF.b();
        }
        int i = iE + this.g + this.d;
        int i2 = this.h;
        if (i > i2) {
            throw gF.a();
        }
        this.h = i;
        f();
        this.i++;
        gHVar.b(this, gCVar);
        a(0);
        this.i--;
        this.h = i2;
        f();
    }

    private int e() throws gF {
        byte bG = g();
        if (bG < 0) {
            int i = bG & 127;
            byte bG2 = g();
            if (bG2 >= 0) {
                return i | (bG2 << 7);
            }
            int i2 = i | ((bG2 & 127) << 7);
            byte bG3 = g();
            if (bG3 >= 0) {
                return i2 | (bG3 << 14);
            }
            int i3 = i2 | ((bG3 & 127) << 14);
            byte bG4 = g();
            if (bG4 >= 0) {
                return i3 | (bG4 << 21);
            }
            int i4 = i3 | ((bG4 & 127) << 21);
            byte bG5 = g();
            int i5 = i4 | (bG5 << 28);
            if (bG5 < 0) {
                for (int i6 = 0; i6 < 5; i6++) {
                    if (g() >= 0) {
                        return i5;
                    }
                }
                throw new gF("CodedInputStream encountered a malformed varint.");
            }
            return i5;
        }
        return bG;
    }

    private gz(InputStream inputStream) {
        this.e = inputStream;
    }

    private void f() {
        this.b += this.c;
        int i = this.g + this.b;
        if (i > this.h) {
            this.c = i - this.h;
            this.b -= this.c;
        } else {
            this.c = 0;
        }
    }

    private boolean a(boolean z) throws gF {
        if (this.d < this.b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.g + this.b == this.h) {
            if (z) {
                throw gF.a();
            }
            return false;
        }
        this.g += this.b;
        this.d = 0;
        this.b = this.e == null ? -1 : this.e.read(this.a);
        if (this.b == 0 || this.b < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
        }
        if (this.b == -1) {
            this.b = 0;
            if (z) {
                throw gF.a();
            }
            return false;
        }
        f();
        int i = this.g + this.b + this.c;
        if (i > this.k || i < 0) {
            throw new gF("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        return true;
    }

    private byte g() throws gF {
        if (this.d == this.b) {
            a(true);
        }
        byte[] bArr = this.a;
        int i = this.d;
        this.d = i + 1;
        return bArr[i];
    }

    private byte[] c(int i) throws gF {
        if (i < 0) {
            throw gF.b();
        }
        if (this.g + this.d + i > this.h) {
            d((this.h - this.g) - this.d);
            throw gF.a();
        }
        if (i <= this.b - this.d) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.a, this.d, bArr, 0, i);
            this.d += i;
            return bArr;
        }
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.b - this.d;
            System.arraycopy(this.a, this.d, bArr2, 0, i2);
            this.d = this.b;
            a(true);
            while (i - i2 > this.b) {
                System.arraycopy(this.a, 0, bArr2, i2, this.b);
                i2 += this.b;
                this.d = this.b;
                a(true);
            }
            System.arraycopy(this.a, 0, bArr2, i2, i - i2);
            this.d = i - i2;
            return bArr2;
        }
        int i3 = this.d;
        int i4 = this.b;
        this.g += this.b;
        this.d = 0;
        this.b = 0;
        int length = i - (i4 - i3);
        ArrayList<byte[]> arrayList = new ArrayList();
        while (length > 0) {
            byte[] bArr3 = new byte[Math.min(length, 4096)];
            int i5 = 0;
            while (i5 < bArr3.length) {
                int i6 = this.e == null ? -1 : this.e.read(bArr3, i5, bArr3.length - i5);
                if (i6 == -1) {
                    throw gF.a();
                }
                this.g += i6;
                i5 += i6;
            }
            length -= bArr3.length;
            arrayList.add(bArr3);
        }
        byte[] bArr4 = new byte[i];
        int length2 = i4 - i3;
        System.arraycopy(this.a, i3, bArr4, 0, length2);
        for (byte[] bArr5 : arrayList) {
            System.arraycopy(bArr5, 0, bArr4, length2, bArr5.length);
            length2 += bArr5.length;
        }
        return bArr4;
    }

    private void d(int i) throws gF {
        if (i < 0) {
            throw gF.b();
        }
        if (this.g + this.d + i > this.h) {
            d((this.h - this.g) - this.d);
            throw gF.a();
        }
        if (i <= this.b - this.d) {
            this.d += i;
            return;
        }
        int i2 = this.b - this.d;
        this.g += i2;
        this.d = 0;
        this.b = 0;
        while (i2 < i) {
            int iSkip = this.e == null ? -1 : (int) this.e.skip(i - i2);
            if (iSkip <= 0) {
                throw gF.a();
            }
            i2 += iSkip;
            this.g = iSkip + this.g;
        }
    }
}
