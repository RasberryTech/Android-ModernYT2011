package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0116cr extends aX {
    C0116cr() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fN fNVar = (fN) guVar.a(fN.class);
        if (attributes.getValue("time") != null) {
            fNVar.d(Uri.parse(attributes.getValue("url")));
        }
    }
}
