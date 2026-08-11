package defpackage;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public final class bR implements aN {
    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((HttpResponse) obj);
    }

    private static fJ a(HttpResponse httpResponse) throws aK {
        try {
            InputStream content = httpResponse.getEntity().getContent();
            bS bSVar = new bS();
            new cS(bSVar).a(content);
            if (bSVar.a == null) {
                throw new aK("Error parsing User");
            }
            return bSVar.a.a();
        } catch (IOException e) {
            throw new aK("IO error parsing User", e);
        }
    }
}
