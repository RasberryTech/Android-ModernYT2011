package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: ft, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0198ft {
    private int a;
    private int b;
    private int c;
    private cJ d;
    private cJ e;
    private cJ f;
    private ArrayList g = new ArrayList();

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int b() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final int c() {
        return this.c;
    }

    public final void c(int i) {
        this.c = i;
    }

    public final ArrayList d() {
        return this.g;
    }

    public final void a(cJ cJVar) {
        this.d = cJVar;
    }

    public final cJ e() {
        return this.e;
    }

    public final void b(cJ cJVar) {
        this.e = cJVar;
    }

    public final cJ f() {
        return this.f;
    }

    public final void c(cJ cJVar) {
        this.f = cJVar;
    }

    public final void a(Object obj) {
        this.g.add(obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GDataEntryPage[");
        sb.append("startIndex=" + this.c + " ");
        sb.append("itemsPerPage=" + this.b + " ");
        sb.append("totalResults=" + this.a + " ");
        sb.append("previousUrl=" + this.e + " ");
        sb.append("selfUrl=" + this.d + " ");
        sb.append("nextUrl=" + this.f + " ");
        sb.append("entries=" + this.g.size() + "]");
        return sb.toString();
    }
}
