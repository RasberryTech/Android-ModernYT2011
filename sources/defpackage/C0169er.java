package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: er, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0169er extends InputStream {
    private InputStream a;
    private C0166eo b;
    private int c;
    private Object d = new Object();
    private volatile boolean e;

    public C0169er(InputStream inputStream, int i) {
        this.a = inputStream;
        this.c = i;
    }

    private int a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = -1;
        if (this.c > 0) {
            try {
                i3 = this.a.read(bArr, i, Math.min(this.c, i2));
                if (i3 > 0) {
                    this.c -= i3;
                }
                if (i3 <= 0 || this.c == 0) {
                    c();
                }
            } catch (IOException e) {
                c();
                throw e;
            }
        }
        return i3;
    }

    private void c() {
        synchronized (this.d) {
            if (!this.e) {
                this.e = true;
                this.d.notifyAll();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015 A[Catch: IOException -> 0x0019, TRY_LEAVE, TryCatch #0 {IOException -> 0x0019, blocks: (B:4:0x0005, B:6:0x000d, B:8:0x0015), top: B:13:0x0005 }] */
    private int d() throws IOException {
        int i = -1;
        if (this.c > 0) {
            try {
                i = this.a.read();
                if (i >= 0) {
                    int i2 = this.c - 1;
                    this.c = i2;
                    if (i2 == 0) {
                        c();
                    }
                } else {
                    c();
                }
            } catch (IOException e) {
                c();
                throw e;
            }
        }
        return i;
    }

    public final void a() {
        synchronized (this.d) {
            while (!this.e) {
                try {
                    this.d.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final void b() {
        synchronized (this) {
            if (this.c == 0 || this.b != null) {
                return;
            }
            this.b = new C0166eo(Math.min(65536, this.c));
            byte[] bArr = new byte[1024];
            while (this.c > 0) {
                try {
                    try {
                        int iA = a(bArr, 0, bArr.length);
                        if (iA <= 0) {
                            throw new IOException("Premature EOF");
                        }
                        this.b.a(bArr, iA);
                    } catch (IOException e) {
                        C0126da.b("DelimitedInputStream", e);
                        this.b.b();
                        return;
                    }
                } catch (Throwable th) {
                    this.b.b();
                    throw th;
                }
            }
            this.b.b();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        super.close();
        do {
        } while (read() >= 0);
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        return this.b != null ? this.b.a() : d();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        return this.b != null ? this.b.a(bArr, i, i2) : a(bArr, i, i2);
    }
}
