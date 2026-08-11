package defpackage;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class fW extends gD {
    private static final fW a = new fW((char) 0);
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private int f;

    /* synthetic */ fW() {
        this((byte) 0);
    }

    static /* synthetic */ boolean a(fW fWVar, boolean z) {
        fWVar.b = true;
        return true;
    }

    static /* synthetic */ boolean b(fW fWVar, boolean z) {
        fWVar.d = true;
        return true;
    }

    private fW(byte b) {
        this.c = "";
        this.e = "";
        this.f = -1;
    }

    private fW(char c) {
        this.c = "";
        this.e = "";
        this.f = -1;
    }

    public static fW a() {
        return a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final boolean f() {
        return this.b && this.d;
    }

    @Override // defpackage.gG
    public final void a(gA gAVar) throws gB, UnsupportedEncodingException {
        j();
        if (this.b) {
            gAVar.a(1, this.c);
        }
        if (this.d) {
            gAVar.a(2, this.e);
        }
    }

    @Override // defpackage.gG
    public final int j() {
        int iB = this.f;
        if (iB == -1) {
            iB = 0;
            if (this.b) {
                iB = gA.b(1, this.c) + 0;
            }
            if (this.d) {
                iB += gA.b(2, this.e);
            }
            this.f = iB;
        }
        return iB;
    }

    public static fX g() {
        return fX.e();
    }
}
