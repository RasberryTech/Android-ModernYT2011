package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: bd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0031bd implements aN {
    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList("channel.global.title.string", "channel.global.description.string", "channel.global.keywords.string", "mobile_watchpage.banner.image.url", "mobile_watchpage.banner.image_target.url")));
    private final aW b;
    private final aO c = new aP().a("/entry", new C0033bf(this)).a("/entry/yt:option", new C0032be(this)).a();

    public C0031bd(aW aWVar) {
        this.b = (aW) gq.a(aWVar, "the parser can't be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aN
    public C0190fl a(HttpResponse httpResponse) throws aK {
        try {
            return ((C0191fm) this.b.a(httpResponse.getEntity().getContent(), this.c)).a();
        } catch (IOException e) {
            throw new aK(e);
        }
    }
}
