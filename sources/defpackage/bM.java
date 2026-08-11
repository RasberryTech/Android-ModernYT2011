package defpackage;

import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class bM extends aX {
    bM(bG bGVar) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fB fBVar = (fB) guVar.a(fB.class);
        if ("http://gdata.youtube.com/schemas/2007/subscriptiontypes.cat".equals(attributes.getValue("scheme"))) {
            fBVar.a(fC.valueOf(attributes.getValue("term").toUpperCase()));
        }
    }
}
