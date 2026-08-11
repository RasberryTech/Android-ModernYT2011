package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: by, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0052by implements aN {
    private final aW a;
    private final aO b = aQ.a().a("/feed/entry", new bF(this)).a("/feed/entry/author/name", new bE(this)).a("/feed/entry/title", new bD(this)).a("/feed/entry/summary", new bC(this)).a("/feed/entry/yt:countHint", new bB(this)).a("/feed/entry/content", new bA(this)).a("/feed/entry/updated", new C0053bz(this)).a();

    public C0052by(aW aWVar) {
        this.a = (aW) gq.a(aWVar, "the parser can't be null");
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
