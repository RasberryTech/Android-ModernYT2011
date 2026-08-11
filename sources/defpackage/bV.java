package defpackage;

import android.net.Uri;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
final class bV extends aX {
    bV(bT bTVar) {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        ((fL) guVar.a(fL.class)).h(Uri.parse(str.trim()));
    }
}
