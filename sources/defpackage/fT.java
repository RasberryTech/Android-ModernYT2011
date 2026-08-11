package defpackage;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class fT extends gE {
    private fQ a;

    static /* synthetic */ fQ a(fT fTVar) throws gF {
        if (!fTVar.a.i()) {
            fQ fQVar = fTVar.a;
            throw new gI().a();
        }
        if (fTVar.a == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (fTVar.a.f != Collections.EMPTY_LIST) {
            fTVar.a.f = Collections.unmodifiableList(fTVar.a.f);
        }
        if (fTVar.a.g != Collections.EMPTY_LIST) {
            fTVar.a.g = Collections.unmodifiableList(fTVar.a.g);
        }
        if (fTVar.a.h != Collections.EMPTY_LIST) {
            fTVar.a.h = Collections.unmodifiableList(fTVar.a.h);
        }
        fQ fQVar2 = fTVar.a;
        fTVar.a = null;
        return fQVar2;
    }

    private fT() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fT d() {
        fT fTVar = new fT();
        fTVar.a = new fQ();
        return fTVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gE, defpackage.gy
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public fT clone() {
        fT fTVarD = d();
        fQ fQVar = this.a;
        if (fQVar != fQ.a()) {
            if (fQVar.b()) {
                fR fRVarC = fQVar.c();
                if (!fTVarD.a.b() || fTVarD.a.c == fR.a()) {
                    fTVarD.a.c = fRVarC;
                } else {
                    fTVarD.a.c = fR.a(fTVarD.a.c).a(fRVarC).a();
                }
                fQ.a(fTVarD.a, true);
            }
            if (fQVar.d()) {
                fTVarD.a(fQVar.e());
            }
            if (!fQVar.f.isEmpty()) {
                if (fTVarD.a.f.isEmpty()) {
                    fTVarD.a.f = new ArrayList();
                }
                fTVarD.a.f.addAll(fQVar.f);
            }
            if (!fQVar.g.isEmpty()) {
                if (fTVarD.a.g.isEmpty()) {
                    fTVarD.a.g = new ArrayList();
                }
                fTVarD.a.g.addAll(fQVar.g);
            }
            if (!fQVar.h.isEmpty()) {
                if (fTVarD.a.h.isEmpty()) {
                    fTVarD.a.h = new ArrayList();
                }
                fTVarD.a.h.addAll(fQVar.h);
            }
        }
        return fTVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gy, defpackage.gH
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public fT b(gz gzVar, gC gCVar) throws gF {
        while (true) {
            int iA = gzVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 10:
                    fS fSVarI = fR.i();
                    if (this.a.b()) {
                        fSVarI.a(this.a.c());
                    }
                    gzVar.a(fSVarI, gCVar);
                    fR fRVarA = fSVarI.a();
                    if (fRVarA == null) {
                        throw new NullPointerException();
                    }
                    fQ.a(this.a, true);
                    this.a.c = fRVarA;
                    break;
                case 18:
                    a(gzVar.d());
                    break;
                case 26:
                    fV fVVarG = fU.g();
                    gzVar.a(fVVarG, gCVar);
                    fU fUVarA = fVVarG.a();
                    if (fUVarA == null) {
                        throw new NullPointerException();
                    }
                    if (this.a.f.isEmpty()) {
                        this.a.f = new ArrayList();
                    }
                    this.a.f.add(fUVarA);
                    break;
                case 34:
                    C0209gd c0209gdV = C0208gc.v();
                    gzVar.a(c0209gdV, gCVar);
                    C0208gc c0208gcA = c0209gdV.a();
                    if (c0208gcA == null) {
                        throw new NullPointerException();
                    }
                    if (this.a.g.isEmpty()) {
                        this.a.g = new ArrayList();
                    }
                    this.a.g.add(c0208gcA);
                    break;
                case 42:
                    C0209gd c0209gdV2 = C0208gc.v();
                    gzVar.a(c0209gdV2, gCVar);
                    C0208gc c0208gcA2 = c0209gdV2.a();
                    if (c0208gcA2 == null) {
                        throw new NullPointerException();
                    }
                    if (this.a.h.isEmpty()) {
                        this.a.h = new ArrayList();
                    }
                    this.a.h.add(c0208gcA2);
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

    private fT a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        fQ.b(this.a, true);
        this.a.e = str;
        return this;
    }
}
