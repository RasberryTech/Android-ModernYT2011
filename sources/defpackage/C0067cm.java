package defpackage;

import android.text.TextUtils;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0067cm extends aX {
    C0067cm() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fN fNVar = (fN) guVar.a(fN.class);
        if (!TextUtils.isEmpty(attributes.getValue("yt:country"))) {
            fNVar.a(true);
        }
    }
}
