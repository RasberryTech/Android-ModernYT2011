package defpackage;

import org.xml.sax.Attributes;

/* JADX INFO: renamed from: ce, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0059ce extends aX {
    C0059ce() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fN fNVar = (fN) guVar.a(fN.class);
        fNVar.d(gv.a(attributes.getValue("numLikes"), 0));
        fNVar.e(gv.a(attributes.getValue("numDislikes"), 0));
    }
}
