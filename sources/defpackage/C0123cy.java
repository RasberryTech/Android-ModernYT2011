package defpackage;

import java.util.Collections;
import java.util.HashSet;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0123cy extends aX {
    C0123cy() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes, String str) {
        if ("monetize".equals(attributes.getValue("action"))) {
            fN fNVar = (fN) guVar.a(fN.class);
            String value = attributes.getValue("permission");
            if ("country".equals(attributes.getValue("type"))) {
                HashSet hashSet = new HashSet();
                Collections.addAll(hashSet, str.trim().toLowerCase().split(" "));
                fNVar.b(hashSet);
                return;
            }
            fNVar.c("allowed".equals(value));
        }
    }
}
