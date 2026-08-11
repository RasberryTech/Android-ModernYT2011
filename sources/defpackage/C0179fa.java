package defpackage;

import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: renamed from: fa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0179fa {
    private Exception a;
    private eP b;
    private DataInputStream c;
    private String d;
    private String[] e;
    private String[] f;
    private int[] g;
    private int[] h;
    private int i;
    private int j;
    private int k;

    public C0179fa(eP ePVar) throws IOException {
        this.b = ePVar;
        this.k = ePVar.g();
        if (this.k == 200) {
            this.c = new DataInputStream(ePVar.b());
            this.d = this.c.readUTF();
            this.k = this.c.readByte();
            this.i = this.c.readByte();
            if (this.i > 0) {
                this.e = new String[this.i];
                this.f = new String[this.i];
                for (int i = 0; i < this.i; i++) {
                    this.e[i] = this.c.readUTF();
                    this.f[i] = this.c.readUTF();
                }
            }
            this.j = this.c.readByte();
            if (this.j > 0) {
                this.g = new int[this.j];
                this.h = new int[this.j];
                for (int i2 = 0; i2 < this.j; i2++) {
                    int i3 = this.c.readInt();
                    int i4 = this.c.readInt();
                    this.g[i2] = i3;
                    this.h[i2] = (i4 - i3) + 1;
                }
            }
            this.c.readInt();
        }
        ePVar.f();
    }

    public C0179fa(Exception exc) {
        this.a = exc;
    }

    public final void a() {
        if (this.b != null) {
            this.b.f();
        }
    }

    public final boolean b() {
        return this.a != null;
    }

    public final Exception c() {
        return this.a;
    }

    public final int d() {
        return this.k;
    }

    public final String e() {
        return this.d;
    }

    public final int f() {
        return this.j;
    }

    public final int[] g() {
        return this.g;
    }

    public final int[] h() {
        return this.h;
    }

    public final DataInputStream i() {
        return this.c;
    }
}
