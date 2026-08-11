package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class fV extends gE {
    private fU a;

    private fV() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fV e() {
        fV fVVar = new fV();
        fVVar.a = new fU();
        return fVVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gE, defpackage.gy
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public fV clone() {
        fV fVVarE = e();
        fU fUVar = this.a;
        if (fUVar != fU.a()) {
            if (fUVar.b()) {
                fVVarE.a(fUVar.c());
            }
            if (fUVar.d()) {
                fVVarE.b(fUVar.e());
            }
        }
        return fVVarE;
    }

    public final fU a() {
        if (this.a == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
        }
        fU fUVar = this.a;
        this.a = null;
        return fUVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gy, defpackage.gH
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public fV b(gz gzVar, gC gCVar) throws gF {
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

    private fV a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fU.a(this.a, true);
        this.a.c = str;
        return this;
    }

    private fV b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fU.b(this.a, true);
        this.a.e = str;
        return this;
    }
}
