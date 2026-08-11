package defpackage;

import android.net.Uri;
import com.google.android.youtube.C0081l;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class bW extends aX {
    bW(bT bTVar) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        fL fLVar = (fL) guVar.a(fL.class);
        String value = attributes.getValue("event");
        if (value == null) {
            C0081l.b("Badly formed tracking event - ignoring");
            return;
        }
        Uri uriC = gv.c(str.trim());
        if ("firstQuartile".equals(value)) {
            fLVar.c(uriC);
            return;
        }
        if ("midpoint".equals(value)) {
            fLVar.d(uriC);
            return;
        }
        if ("thirdQuartile".equals(value)) {
            fLVar.e(uriC);
        } else if ("complete".equals(value)) {
            fLVar.f(uriC);
        } else if ("close".equals(value)) {
            fLVar.g(uriC);
        }
    }
}
