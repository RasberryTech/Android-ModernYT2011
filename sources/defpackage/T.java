package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class T implements I {
    private final I a;
    private /* synthetic */ S b;

    public T(S s, I i) {
        this.b = s;
        this.a = (I) gq.a(i, "targetCallback can't be null");
    }

    @Override // defpackage.I
    public final void a(Object obj, Object obj2) {
        this.b.b.a(this.b.a(obj, obj2));
        this.a.a(obj, obj2);
    }

    @Override // defpackage.I
    public final void a(Object obj, Exception exc) {
        this.a.a(obj, exc);
    }
}
