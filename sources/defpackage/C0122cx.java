package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0122cx extends aX {
    C0122cx() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        ((fN) guVar.a(fN.class)).f(Uri.parse(attributes.getValue("href")));
    }
}
