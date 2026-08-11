package defpackage;

/* JADX INFO: renamed from: al, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0012al implements I {
    private final I a;
    private /* synthetic */ C0011ak b;

    public C0012al(C0011ak c0011ak, I i) {
        this.b = c0011ak;
        this.a = i;
    }

    @Override // defpackage.I
    public final void a(Object obj, Object obj2) {
        this.b.a.a(obj, new C0010aj(obj2, this.b.c.a()));
        this.a.a(obj, obj2);
    }

    @Override // defpackage.I
    public final void a(Object obj, Exception exc) {
        this.a.a(obj, exc);
    }
}
