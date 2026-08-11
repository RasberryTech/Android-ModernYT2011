package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class bA extends aX {
    bA(C0052by c0052by) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        ((C0203fy) guVar.a(C0203fy.class)).a(Uri.parse(attributes.getValue("src")));
    }
}
