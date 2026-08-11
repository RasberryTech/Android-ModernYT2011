package defpackage;

/* JADX INFO: renamed from: ez, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0177ez implements InterfaceC0156ee {
    private /* synthetic */ Object a;

    C0177ez(C0176ey c0176ey, Object obj) {
        this.a = obj;
    }

    @Override // defpackage.InterfaceC0156ee
    public final void a() {
        synchronized (this.a) {
            this.a.notifyAll();
        }
    }
}
