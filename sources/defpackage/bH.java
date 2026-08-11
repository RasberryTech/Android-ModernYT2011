package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class bH extends aX {
    bH(bG bGVar) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        if (attributes.getValue("rel").equals("edit")) {
            ((fB) guVar.a(fB.class)).b(Uri.parse(attributes.getValue("href")));
        }
    }
}
