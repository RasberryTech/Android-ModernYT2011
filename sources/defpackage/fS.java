package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class fS extends gE {
    private fR a;

    private fS() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fS e() {
        fS fSVar = new fS();
        fSVar.a = new fR();
        return fSVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gE, defpackage.gy
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public fS clone() {
        return e().a(this.a);
    }

    public final fR a() {
        if (this.a == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
        }
        fR fRVar = this.a;
        this.a = null;
        return fRVar;
    }

    public final fS a(fR fRVar) {
        if (fRVar == fR.a()) {
            return this;
        }
        if (fRVar.b()) {
            a(fRVar.c());
        }
        if (fRVar.d()) {
            b(fRVar.e());
        }
        if (fRVar.f()) {
            c(fRVar.g());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gy, defpackage.gH
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public fS b(gz gzVar, gC gCVar) throws gF {
        while (true) {
            int iA = gzVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 10:
                    a(gzVar.d());
                    break;
                case 18:
                    b(gzVar.d());
                    break;
                case 26:
                    c(gzVar.d());
                    break;
                default:
                    if (!gzVar.b(iA)) {
                        return this;
                    }
                    break;
                    break;
            }
        }
    }

    private fS a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fR.a(this.a, true);
        this.a.c = str;
        return this;
    }

    private fS b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fR.b(this.a, true);
        this.a.e = str;
        return this;
    }

    private fS c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fR.c(this.a, true);
        this.a.g = str;
        return this;
    }
}
