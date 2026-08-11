package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class fX extends gE {
    private fW a;

    private fX() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fX e() {
        fX fXVar = new fX();
        fXVar.a = new fW();
        return fXVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gE, defpackage.gy
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public fX clone() {
        fX fXVarE = e();
        fW fWVar = this.a;
        if (fWVar != fW.a()) {
            if (fWVar.b()) {
                fXVarE.a(fWVar.c());
            }
            if (fWVar.d()) {
                fXVarE.b(fWVar.e());
            }
        }
        return fXVarE;
    }

    public final fW a() {
        if (this.a != null && !this.a.f()) {
            fW fWVar = this.a;
            throw new gI();
        }
        if (this.a == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
        }
        fW fWVar2 = this.a;
        this.a = null;
        return fWVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gy, defpackage.gH
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public fX b(gz gzVar, gC gCVar) throws gF {
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
                default:
                    if (!gzVar.b(iA)) {
                        return this;
                    }
                    break;
                    break;
            }
        }
    }

    public final fX a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fW.a(this.a, true);
        this.a.c = str;
        return this;
    }

    public final fX b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fW.b(this.a, true);
        this.a.e = str;
        return this;
    }
}
