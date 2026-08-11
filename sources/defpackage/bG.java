package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public final class bG implements aN {
    private final aW a;
    private final aO b = aQ.a().a("/feed/entry", new bN(this)).a("/feed/entry/category", new bM(this)).a("/feed/entry/content", new bL(this)).a("/feed/entry/yt:username", new bK(this)).a("/feed/entry/yt:playlistTitle", new bJ(this)).a("/feed/entry/yt:queryString", new bI(this)).a("/feed/entry/link", new bH(this)).a();

    public bG(aW aWVar) {
        this.a = aWVar;
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
