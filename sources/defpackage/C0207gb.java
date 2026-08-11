package defpackage;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: renamed from: gb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0207gb extends gE {
    private C0206ga a;

    static /* synthetic */ C0206ga a(C0207gb c0207gb) throws gF {
        if (!c0207gb.a.c()) {
            C0206ga c0206ga = c0207gb.a;
            throw new gI().a();
        }
        if (c0207gb.a == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (c0207gb.a.b != Collections.EMPTY_LIST) {
            c0207gb.a.b = Collections.unmodifiableList(c0207gb.a.b);
        }
        C0206ga c0206ga2 = c0207gb.a;
        c0207gb.a = null;
        return c0206ga2;
    }

    private C0207gb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0207gb d() {
        C0207gb c0207gb = new C0207gb();
        c0207gb.a = new C0206ga();
        return c0207gb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gE, defpackage.gy
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0207gb clone() {
        C0207gb c0207gbD = d();
        C0206ga c0206ga = this.a;
        if (c0206ga != C0206ga.a() && !c0206ga.b.isEmpty()) {
            if (c0207gbD.a.b.isEmpty()) {
                c0207gbD.a.b = new ArrayList();
            }
            c0207gbD.a.b.addAll(c0206ga.b);
        }
        return c0207gbD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.gy, defpackage.gH
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0207gb b(gz gzVar, gC gCVar) throws gF {
        while (true) {
            int iA = gzVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 10:
                    C0209gd c0209gdV = C0208gc.v();
                    gzVar.a(c0209gdV, gCVar);
                    C0208gc c0208gcA = c0209gdV.a();
                    if (c0208gcA == null) {
                        throw new NullPointerException();
                    }
                    if (this.a.b.isEmpty()) {
                        this.a.b = new ArrayList();
                    }
                    this.a.b.add(c0208gcA);
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
}
