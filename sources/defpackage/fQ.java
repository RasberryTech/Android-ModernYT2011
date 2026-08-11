package defpackage;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class fQ extends gD {
    private static final fQ a;
    private boolean b;
    private fR c;
    private boolean d;
    private String e;
    private List f;
    private List g;
    private List h;
    private int i;

    /* synthetic */ fQ() {
        this((byte) 0);
    }

    static /* synthetic */ boolean a(fQ fQVar, boolean z) {
        fQVar.b = true;
        return true;
    }

    static /* synthetic */ boolean b(fQ fQVar, boolean z) {
        fQVar.d = true;
        return true;
    }

    private fQ(byte b) {
        this.e = "";
        this.f = Collections.emptyList();
        this.g = Collections.emptyList();
        this.h = Collections.emptyList();
        this.i = -1;
        this.c = fR.a();
    }

    private fQ(char c) {
        this.e = "";
        this.f = Collections.emptyList();
        this.g = Collections.emptyList();
        this.h = Collections.emptyList();
        this.i = -1;
    }

    public static fQ a() {
        return a;
    }

    public final boolean b() {
        return this.b;
    }

    public final fR c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final List f() {
        return this.f;
    }

    public final List g() {
        return this.g;
    }

    public final List h() {
        return this.h;
    }

    public final boolean i() {
        if (this.b && this.c.h()) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                if (!((fU) it.next()).f()) {
                    return false;
                }
            }
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                if (!((C0208gc) it2.next()).u()) {
                    return false;
                }
            }
            Iterator it3 = this.h.iterator();
            while (it3.hasNext()) {
                if (!((C0208gc) it3.next()).u()) {
                    return false;
                }
            }
            return true;
        }
        return false;
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
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            gAVar.a(3, (fU) it.next());
        }
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            gAVar.a(4, (C0208gc) it2.next());
        }
        Iterator it3 = this.h.iterator();
        while (it3.hasNext()) {
            gAVar.a(5, (C0208gc) it3.next());
        }
    }

    @Override // defpackage.gG
    public final int j() {
        int iB;
        int i = this.i;
        if (i == -1) {
            int iB2 = 0;
            if (this.b) {
                iB2 = gA.b(1, this.c) + 0;
            }
            if (this.d) {
                iB2 += gA.b(2, this.e);
            }
            Iterator it = this.f.iterator();
            while (true) {
                iB = iB2;
                if (!it.hasNext()) {
                    break;
                }
                iB2 = gA.b(3, (fU) it.next()) + iB;
            }
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                iB = gA.b(4, (C0208gc) it2.next()) + iB;
            }
            Iterator it3 = this.h.iterator();
            while (it3.hasNext()) {
                iB = gA.b(5, (C0208gc) it3.next()) + iB;
            }
            this.i = iB;
            return iB;
        }
        return i;
    }

    public static fQ a(InputStream inputStream) {
        return fT.a((fT) fT.d().a(inputStream));
    }

    static {
        fQ fQVar = new fQ((char) 0);
        a = fQVar;
        fQVar.c = fR.a();
    }
}
