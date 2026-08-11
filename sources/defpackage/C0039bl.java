package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: bl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0039bl implements aN {
    private final aW a;
    private final aO b = aQ.a("/feed").a("/feed/entry", new C0045br(this)).a("/feed/entry/author/name", new C0044bq(this)).a("/feed/entry/category", new C0043bp(this)).a("/feed/entry/updated", new C0042bo(this)).a("/feed/entry/yt:videoid", new C0041bn(this)).a("/feed/entry/yt:username", new C0040bm(this)).a();

    public C0039bl(aW aWVar) {
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
