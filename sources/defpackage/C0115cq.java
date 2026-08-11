package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0115cq extends aX {
    C0115cq() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        ((fN) guVar.a(fN.class)).c(Uri.parse(attributes.getValue("url")));
    }
}
