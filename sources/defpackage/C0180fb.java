package defpackage;

import java.util.Vector;

/* JADX INFO: renamed from: fb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0180fb extends eY {
    private C0171et c;
    private eE d;
    private dZ e;
    private dY f;
    private Vector a = new Vector();
    private Object b = new Object();
    private int g = 16384;

    public C0180fb(C0171et c0171et, dZ dZVar, eE eEVar) {
        this.c = c0171et;
        this.e = dZVar;
        this.d = eEVar;
        this.f = new dY(dZVar, new RunnableC0185fg(this));
    }
}
