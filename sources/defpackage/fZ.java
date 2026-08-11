package defpackage;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class fZ extends gE {
    private fY a;

    private fZ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fZ e() {
        fZ fZVar = new fZ();
        fZVar.a = new fY();
        return fZVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gE, defpackage.gy
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public fZ clone() {
        fZ fZVarE = e();
        fY fYVar = this.a;
        if (fYVar != fY.a()) {
            if (fYVar.b()) {
                fZVarE.a(fYVar.c());
            }
            if (!fYVar.d.isEmpty()) {
                if (fZVarE.a.d.isEmpty()) {
                    fZVarE.a.d = new ArrayList();
                }
                fZVarE.a.d.addAll(fYVar.d);
            }
        }
        return fZVarE;
    }

    public final fY a() {
        if (this.a != null && !this.a.d()) {
            fY fYVar = this.a;
            throw new gI();
        }
        if (this.a == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.a.d != Collections.EMPTY_LIST) {
            this.a.d = Collections.unmodifiableList(this.a.d);
        }
        fY fYVar2 = this.a;
        this.a = null;
        return fYVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gy, defpackage.gH
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public fZ b(gz gzVar, gC gCVar) throws gF {
        while (true) {
            int iA = gzVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 10:
                    a(gzVar.d());
                    break;
                case 18:
                    String strD = gzVar.d();
                    if (strD == null) {
                        throw new NullPointerException();
                    }
                    if (this.a.d.isEmpty()) {
                        this.a.d = new ArrayList();
                    }
                    this.a.d.add(strD);
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

    public final fZ a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fY.a(this.a, true);
        this.a.c = str;
        return this;
    }

    public final fZ a(Iterable iterable) {
        if (this.a.d.isEmpty()) {
            this.a.d = new ArrayList();
        }
        gE.a(iterable, this.a.d);
        return this;
    }
}
