package defpackage;

import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class aV implements InterfaceC0028ba {
    aV() {
    }

    @Override // defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        guVar.offer(new C0201fw());
    }

    @Override // defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        guVar.poll();
    }
}
