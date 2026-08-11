package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0056cb implements aN {
    private final aW a;
    private final aO b;

    public C0056cb(aW aWVar) {
        this.a = (aW) gq.a(aWVar, "the parser can't be null");
        aP aPVar = new aP();
        C0057cc.b(aPVar, "");
        this.b = aPVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aN
    public fM a(HttpResponse httpResponse) throws aK {
        try {
            return ((fN) this.a.a(httpResponse.getEntity().getContent(), this.b)).a();
        } catch (IOException e) {
            throw new aK(e);
        }
    }
}
