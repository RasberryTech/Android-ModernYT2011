package defpackage;

import java.util.Vector;

/* JADX INFO: renamed from: ed, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0155ed {
    private Vector a = new Vector();

    private InterfaceC0156ee[] a() {
        InterfaceC0156ee[] interfaceC0156eeArr;
        synchronized (this.a) {
            interfaceC0156eeArr = new InterfaceC0156ee[this.a.size()];
            this.a.copyInto(interfaceC0156eeArr);
        }
        return interfaceC0156eeArr;
    }

    public final void a(InterfaceC0156ee interfaceC0156ee) {
        synchronized (this.a) {
            if (this.a.indexOf(interfaceC0156ee) == -1) {
                this.a.addElement(interfaceC0156ee);
            }
        }
    }

    public final void g() {
        for (InterfaceC0156ee interfaceC0156ee : a()) {
            interfaceC0156ee.a();
        }
    }
}
