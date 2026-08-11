package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: bg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0034bg implements aN {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aN
    public List a(HttpResponse httpResponse) throws aK {
        C0036bi c0036bi = new C0036bi();
        try {
            new cL(c0036bi).a(httpResponse.getEntity().getContent());
            if (c0036bi.a == null) {
                throw new aK("Error parsing categories", c0036bi.b);
            }
            ArrayList arrayList = c0036bi.a;
            Collections.sort(arrayList, new C0035bh(this));
            return arrayList;
        } catch (IOException e) {
            throw new aK("IO error parsing category", e);
        }
    }
}
