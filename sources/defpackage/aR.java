package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class aR extends aX {
    aR() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        String value = attributes.getValue("rel");
        if (aQ.a.contains(value)) {
            C0201fw c0201fw = (C0201fw) guVar.a(C0201fw.class);
            Uri uri = Uri.parse(attributes.getValue("href"));
            if ("next".equals(value)) {
                c0201fw.b(uri);
            } else if ("previous".equals(value)) {
                c0201fw.a(uri);
            }
        }
    }
}
