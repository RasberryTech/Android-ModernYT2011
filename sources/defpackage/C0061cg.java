package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0061cg extends aX {
    C0061cg() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fN fNVar = (fN) guVar.a(fN.class);
        String value = attributes.getValue("rel");
        if (C0057cc.b.contains(value)) {
            Uri uri = Uri.parse(attributes.getValue("href"));
            if ("http://gdata.youtube.com/schemas/2007#video.related".equals(value)) {
                fNVar.g(uri);
                return;
            }
            if ("edit".equals(value)) {
                fNVar.e(uri);
                return;
            }
            if ("http://gdata.youtube.com/schemas/2007#video.ratings".equals(value)) {
                fNVar.h(uri);
            } else if ("http://gdata.youtube.com/schemas/2007#video.captionTracks".equals(value) && "true".equals(attributes.getValue("yt:hasEntries"))) {
                fNVar.i(uri);
            }
        }
    }
}
