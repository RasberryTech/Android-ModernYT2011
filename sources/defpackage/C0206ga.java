package defpackage;

import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: ga, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0206ga extends gD {
    private static final C0206ga a = new C0206ga((char) 0);
    private List b;
    private int c;

    /* synthetic */ C0206ga() {
        this((byte) 0);
    }

    private C0206ga(byte b) {
        this.b = Collections.emptyList();
        this.c = -1;
    }

    private C0206ga(char c) {
        this.b = Collections.emptyList();
        this.c = -1;
    }

    public static C0206ga a() {
        return a;
    }

    public final List b() {
        return this.b;
    }

    public final boolean c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (!((C0208gc) it.next()).u()) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.gG
    public final void a(gA gAVar) throws gB {
        j();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            gAVar.a(1, (C0208gc) it.next());
        }
    }

    @Override // defpackage.gG
    public final int j() {
        int i = this.c;
        if (i == -1) {
            int iB = 0;
            Iterator it = this.b.iterator();
            while (true) {
                int i2 = iB;
                if (it.hasNext()) {
                    iB = gA.b(1, (C0208gc) it.next()) + i2;
                } else {
                    this.c = i2;
                    return i2;
                }
            }
        } else {
            return i;
        }
    }

    public static C0206ga a(InputStream inputStream) {
        return C0207gb.a((C0207gb) C0207gb.d().a(inputStream));
    }
}
