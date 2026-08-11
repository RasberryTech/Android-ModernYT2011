package defpackage;

import java.util.Collections;
import java.util.HashSet;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0068cn extends aX {
    C0068cn() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        fN fNVar = (fN) guVar.a(fN.class);
        if ("country".equals(attributes.getValue("type")) && "deny".equals(attributes.getValue("relationship"))) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, str.trim().toLowerCase().split(" "));
            fNVar.a(hashSet);
        }
    }
}
