package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: be, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0032be extends aX {
    C0032be(C0031bd c0031bd) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        C0191fm c0191fm = (C0191fm) guVar.peek();
        String value = attributes.getValue("name");
        if (C0031bd.a.contains(value)) {
            if ("channel.global.title.string".equals(value)) {
                c0191fm.a(str);
                return;
            }
            if ("channel.global.description.string".equals(value)) {
                c0191fm.b(str);
                return;
            }
            if ("channel.global.keywords.string".equals(value)) {
                c0191fm.c(str);
            } else if ("mobile_watchpage.banner.image.url".equals(value)) {
                c0191fm.a(Uri.parse(str));
            } else if ("mobile_watchpage.banner.image_target.url".equals(value)) {
                c0191fm.b(Uri.parse(str));
            }
        }
    }
}
