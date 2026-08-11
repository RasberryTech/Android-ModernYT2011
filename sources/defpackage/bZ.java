package defpackage;

import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class bZ extends aX {
    bZ(bT bTVar) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        guVar.offer(new fL());
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        guVar.poll();
    }
}
