package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0037bj implements aN {
    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((HttpResponse) obj);
    }

    private static C0200fv a(HttpResponse httpResponse) throws aK {
        try {
            C0038bk c0038bk = new C0038bk();
            new cN(c0038bk).a(httpResponse.getEntity().getContent());
            if (c0038bk.a == null) {
                throw new aK("Error parsing a Comment page", c0038bk.b);
            }
            return gv.a(c0038bk.a);
        } catch (IOException e) {
            throw new aK("IO error converting page of comments", e);
        }
    }
}
