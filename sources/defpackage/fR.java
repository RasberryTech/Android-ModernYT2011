package defpackage;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class fR extends gD {
    private static final fR a = new fR((char) 0);
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private boolean f;
    private String g;
    private int h;

    /* synthetic */ fR() {
        this((byte) 0);
    }

    static /* synthetic */ boolean a(fR fRVar, boolean z) {
        fRVar.b = true;
        return true;
    }

    static /* synthetic */ boolean b(fR fRVar, boolean z) {
        fRVar.d = true;
        return true;
    }

    static /* synthetic */ boolean c(fR fRVar, boolean z) {
        fRVar.f = true;
        return true;
    }

    private fR(byte b) {
        this.c = "";
        this.e = "";
        this.g = "";
        this.h = -1;
    }

    private fR(char c) {
        this.c = "";
        this.e = "";
        this.g = "";
        this.h = -1;
    }

    public static fR a() {
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
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
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
        if (this.f) {
            gAVar.a(3, this.g);
        }
    }

    @Override // defpackage.gG
    public final int j() {
        int iB = this.h;
        if (iB == -1) {
            iB = 0;
            if (this.b) {
                iB = gA.b(1, this.c) + 0;
            }
            if (this.d) {
                iB += gA.b(2, this.e);
            }
            if (this.f) {
                iB += gA.b(3, this.g);
            }
            this.h = iB;
        }
        return iB;
    }

    public static fS i() {
        return fS.e();
    }

    public static fS a(fR fRVar) {
        return fS.e().a(fRVar);
    }
}
