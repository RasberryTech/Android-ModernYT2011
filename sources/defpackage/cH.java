package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class cH extends Exception {
    private final cI a;

    public cH(Throwable th, cI cIVar) {
        super(th);
        this.a = cIVar;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + " [" + this.a + "]";
    }
}
