package defpackage;

/* JADX INFO: renamed from: dr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0142dr implements InterfaceC0145du {
    private boolean a = false;
    private boolean b = false;
    private dC c = cX.a().g();
    private final String d;

    protected AbstractC0142dr(String str) {
        this.d = str;
    }

    @Override // defpackage.InterfaceC0145du
    public final synchronized boolean a(boolean z) {
        if (!this.b) {
            boolean z2 = this.c.a(this.d) != null;
            this.b = true;
            this.a = z2;
        }
        boolean z3 = this.a;
        this.a = true;
        this.c.a(this.d, new byte[]{0});
        return true;
    }
}
