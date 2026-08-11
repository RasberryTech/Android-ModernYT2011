package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: cc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0057cc {
    private static final HashMap a;
    private static final Set b;

    static {
        HashMap map = new HashMap(10);
        a = map;
        map.put(null, fO.PLAYABLE);
        a.put("processing", fO.PROCESSING);
        a.put("deleted", fO.DELETED);
        a.put("requesterRegion", fO.COUNTRY_RESTRICTED);
        a.put("limitedSyndication", fO.NOT_AVAILABLE_ON_MOBILE);
        a.put("private", fO.PRIVATE);
        a.put("copyright", fO.COPYRIGHT);
        a.put("inappropriate", fO.INAPPROPRIATE);
        a.put("duplicate", fO.DUPLICATE);
        a.put("termsOfUse", fO.TERMS_OF_USE);
        a.put("suspended", fO.ACCOUNT_SUSPENDED);
        a.put("tooLong", fO.VIDEO_TOO_LONG);
        a.put("blocked", fO.BLOCKED_BY_OWNER);
        a.put("cantProcess", fO.CANT_PROCESS);
        a.put("invalidFormat", fO.INVALID_FORMAT);
        a.put("unsupportedCodec", fO.UNSUPPORTED_CODEC);
        a.put("empty", fO.EMPTY);
        a.put("tooSmall", fO.TOO_SMALL);
        b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http://gdata.youtube.com/schemas/2007#video.related", "http://gdata.youtube.com/schemas/2007#video.ratings", "edit", "http://gdata.youtube.com/schemas/2007#video.captionTracks")));
    }

    public static void a(aP aPVar, String str) {
        gq.a(aPVar, "rules may not be null");
        c(aPVar, str);
        aPVar.a(str + "/entry", new C0058cd());
    }

    public static void b(aP aPVar, String str) {
        gq.a(aPVar, "rules may not be null");
        c(aPVar, str);
        aPVar.a(str + "/entry", new C0069co());
    }

    private static void c(aP aPVar, String str) {
        aPVar.a(str + "/entry/media:group/media:content", new C0117cs()).a(str + "/entry/media:group/media:thumbnail", new C0116cr()).a(str + "/entry/media:group/media:player", new C0115cq()).a(str + "/entry/media:group/yt:duration", new C0114cp()).a(str + "/entry/media:group/media:restriction", new C0068cn()).a(str + "/entry/media:group/media:rating", new C0067cm()).a(str + "/entry/media:group/yt:videoid", new C0066cl()).a(str + "/entry/media:group/media:credit", new C0065ck()).a(str + "/entry/media:group/media:description", new C0064cj()).a(str + "/entry/media:group/media:keywords", new C0063ci()).a(str + "/entry/yt:statistics", new C0062ch()).a(str + "/entry/link", new C0061cg()).a(str + "/entry/category", new C0060cf()).a(str + "/entry/yt:rating", new C0059ce()).a(str + "/entry/yt:claimed", new C0124cz()).a(str + "/entry/yt:accessControl", new C0123cy()).a(str + "/entry/gd:comments/gd:feedLink", new C0122cx()).a(str + "/entry/app:control/yt:state", new C0121cw()).a(str + "/entry/published", new C0120cv()).a(str + "/entry/media:group/yt:uploaded", new C0119cu()).a(str + "/entry/title", new C0118ct());
    }
}
