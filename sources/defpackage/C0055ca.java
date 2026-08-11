package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: ca, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0055ca implements aN {
    private final aW a;
    private final aO b;

    public C0055ca(aW aWVar) {
        this.a = (aW) gq.a(aWVar, "the parser can't be null");
        aP aPVarA = aQ.a("/feed");
        C0057cc.a(aPVarA, "/feed");
        this.b = aPVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aN
    public C0200fv a(HttpResponse httpResponse) throws aK {
        try {
            return ((C0201fw) this.a.a(httpResponse.getEntity().getContent(), this.b)).a();
        } catch (IOException e) {
            throw new aK(e);
        }
    }
}
