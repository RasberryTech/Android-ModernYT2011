package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class bL extends aX {
    bL(bG bGVar) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        ((fB) guVar.a(fB.class)).a(Uri.parse(attributes.getValue("src")));
    }
}
