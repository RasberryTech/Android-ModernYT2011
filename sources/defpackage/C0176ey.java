package defpackage;

import java.io.DataInputStream;

/* JADX INFO: renamed from: ey, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0176ey extends C0165en {
    public C0176ey(String str, boolean z) {
        super(str, z);
    }

    private void l() {
        Object obj = new Object();
        synchronized (obj) {
            if (h()) {
                a(new C0177ez(this, obj));
                k();
            }
            while (!i() && !j()) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    @Override // defpackage.C0165en
    public final String a(String str) {
        l();
        return super.a(str);
    }

    @Override // defpackage.C0165en, defpackage.InterfaceC0146dv
    public final DataInputStream b() {
        l();
        return super.b();
    }

    @Override // defpackage.C0165en, defpackage.InterfaceC0146dv
    public final int c() {
        l();
        return super.c();
    }

    @Override // defpackage.C0165en, defpackage.InterfaceC0146dv
    public final String d() {
        l();
        return super.d();
    }

    @Override // defpackage.C0165en, defpackage.InterfaceC0146dv
    public final long e() {
        l();
        return super.e();
    }
}
