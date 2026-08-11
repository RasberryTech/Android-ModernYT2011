package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class cR extends cU {
    private Object a;

    protected cR(cG cGVar) {
        super(cGVar);
    }

    @Override // defpackage.cU
    protected void b() {
        super.b();
        this.a = null;
    }

    public final Object c() {
        return this.a;
    }

    protected final void a(Object obj) {
        this.a = obj;
    }
}
