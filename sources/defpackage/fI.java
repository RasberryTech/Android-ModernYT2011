package defpackage;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class fI {
    private String a;
    private int b;
    private cJ c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public final void a(String str) {
        this.a = str;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(cJ cJVar) {
        this.c = cJVar;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void d(int i) {
        this.f = i;
    }

    public final void e(int i) {
        this.g = i;
    }

    public final void f(int i) {
        this.h = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfo[");
        sb.append("account=" + ((String) null) + " ");
        sb.append("username=" + this.a + " ");
        sb.append("authToken=" + ((String) null));
        sb.append("]");
        return sb.toString();
    }

    public final fJ a() {
        return new fJ(this.a, this.b, Uri.parse(this.c.toString()), this.d, this.e, this.f, this.g, this.h);
    }
}
