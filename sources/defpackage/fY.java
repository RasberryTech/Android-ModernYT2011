package defpackage;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class fY extends gD {
    private static final fY a = new fY((char) 0);
    private boolean b;
    private String c;
    private List d;
    private int e;

    /* synthetic */ fY() {
        this((byte) 0);
    }

    static /* synthetic */ boolean a(fY fYVar, boolean z) {
        fYVar.b = true;
        return true;
    }

    private fY(byte b) {
        this.c = "";
        this.d = Collections.emptyList();
        this.e = -1;
    }

    private fY(char c) {
        this.c = "";
        this.d = Collections.emptyList();
        this.e = -1;
    }

    public static fY a() {
        return a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.b;
    }

    @Override // defpackage.gG
    public final void a(gA gAVar) throws gB, UnsupportedEncodingException {
        j();
        if (this.b) {
            gAVar.a(1, this.c);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            gAVar.a(2, (String) it.next());
        }
    }

    @Override // defpackage.gG
    public final int j() {
        int iA = 0;
        int i = this.e;
        if (i == -1) {
            int iB = this.b ? gA.b(1, this.c) + 0 : 0;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                iA = gA.a((String) it.next()) + iA;
            }
            int size = iB + iA + (this.d.size() * 1);
            this.e = size;
            return size;
        }
        return i;
    }

    public static fZ e() {
        return fZ.e();
    }
}
