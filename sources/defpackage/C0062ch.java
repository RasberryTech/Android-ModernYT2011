package defpackage;

import org.xml.sax.Attributes;

/* JADX INFO: renamed from: ch, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0062ch extends aX {
    C0062ch() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fN fNVar = (fN) guVar.a(fN.class);
        fNVar.b(gv.a(attributes.getValue("viewCount"), 0));
        fNVar.c(gv.a(attributes.getValue("favoriteCount"), 0));
    }
}
