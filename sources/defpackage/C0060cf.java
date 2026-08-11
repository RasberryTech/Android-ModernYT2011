package defpackage;

import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0060cf extends aX {
    C0060cf() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fN fNVar = (fN) guVar.a(fN.class);
        if ("http://gdata.youtube.com/schemas/2007/categories.cat".equals(attributes.getValue("scheme"))) {
            fNVar.d(attributes.getValue("label"));
        }
    }
}
