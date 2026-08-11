package defpackage;

import org.xml.sax.Attributes;

/* JADX INFO: renamed from: bp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0043bp extends aX {
    C0043bp(C0039bl c0039bl) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        if ("http://gdata.youtube.com/schemas/2007/userevents.cat".equals(attributes.getValue("scheme"))) {
            ((C0197fs) guVar.a(C0197fs.class)).a(EnumC0196fr.valueOf(attributes.getValue("term").toUpperCase()));
        }
    }
}
