package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class V {
    private static volatile gs d;
    private static volatile String e;
    private static Uri b = new Uri.Builder().scheme("http").authority("gdata.youtube.com").appendPath("feeds").appendPath("api").build();
    private static final HashSet c = new HashSet(Arrays.asList("zh-TW", "cs-CZ", "nl-NL", "en-GB", "en-US", "fr-FR", "de-DE", "it-IT", "ja-JP", "ko-KR", "pl-PL", "pt-BR", "ru-RU", "es-ES", "es-MX", "sv-SE"));
    public static final Set a = new HashSet(Arrays.asList("AU", "BR", "CA", "CZ", "DE", "DK", "ES", "FI", "FR", "GB", "GR", "HK", "HU", "IE", "IL", "IN", "IT", "JP", "KR", "MX", "NL", "NO", "NZ", "PL", "PT", "RU", "SE", "TW", "US"));

    public static void a(gs gsVar) {
        d = gsVar;
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String upperCase = str.toUpperCase();
            if (a.contains(upperCase)) {
                e = upperCase;
                return;
            }
        }
        e = null;
    }

    public static U b(String str) {
        gq.a(str);
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("videos").appendPath(str);
        b(builderAppendPath);
        return U.a(builderAppendPath.build());
    }

    public static U a(String str, X x) {
        gq.a(str, (Object) "query cannot be empty");
        Uri.Builder builderAppendQueryParameter = b.buildUpon().appendPath("videos").appendQueryParameter("q", str);
        if (x != null) {
            builderAppendQueryParameter.appendQueryParameter("time", x.toString());
        }
        a(builderAppendQueryParameter);
        return U.a(builderAppendQueryParameter.build());
    }

    public static U a() {
        return U.a(b.buildUpon().appendPath("thefeed").build());
    }

    public static U a(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        return U.a(b.buildUpon().appendPath("thefeed").appendPath(fHVar.c).build(), fHVar.b);
    }

    public static U a(Uri uri) {
        return U.a(uri);
    }

    public static U a(Uri uri, String str) {
        return U.a(uri, str);
    }

    public static U b(Uri uri) {
        return U.a(uri);
    }

    public static U c(String str) {
        gq.a(str, (Object) "username cannot be empty");
        return U.a(i(str));
    }

    public static U b(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        return U.a(i(fHVar.c), fHVar.b);
    }

    private static Uri i(String str) {
        return b.buildUpon().appendPath("users").appendPath(str).build();
    }

    public static U d(String str) {
        gq.a(str, (Object) "username cannot be empty");
        return U.a(j(str));
    }

    public static U c(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        return U.a(j(fHVar.c), fHVar.b);
    }

    private static Uri j(String str) {
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("users").appendPath(str).appendPath("uploads");
        a(builderAppendPath, 1, 10);
        return builderAppendPath.build();
    }

    public static U e(String str) {
        gq.a(str, (Object) "username cannot be empty");
        return U.a(k(str));
    }

    public static U d(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        return U.a(k(fHVar.c), fHVar.b);
    }

    private static Uri k(String str) {
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("users").appendPath(str).appendPath("favorites");
        a(builderAppendPath, 1, 10);
        return builderAppendPath.build();
    }

    public static U f(String str) {
        gq.a(str, (Object) "Username cannot be empty");
        Uri.Builder builderAppendQueryParameter = b.buildUpon().appendPath("events").appendQueryParameter("author", str);
        a(builderAppendQueryParameter, 1, 10);
        return U.a(builderAppendQueryParameter.build());
    }

    public static U a(String str, String str2) {
        Uri.Builder builderEncodedPath = new Uri.Builder().scheme("http").authority("gdata.youtube.com").encodedPath("schemas/2007/categories.cat");
        if (str != null && str2 != null) {
            String str3 = str.toLowerCase() + "-" + str2.toUpperCase();
            if (c.contains(str3)) {
                builderEncodedPath.appendQueryParameter("hl", str3);
            }
        }
        return U.a(builderEncodedPath.build());
    }

    public static U g(String str) {
        gq.a((Object) str, (Object) "username cannot be null");
        return U.a(l(str));
    }

    public static U e(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        return U.a(l(fHVar.c), fHVar.b);
    }

    private static Uri l(String str) {
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("users").appendPath(str).appendPath("playlists");
        a(builderAppendPath, 1, 50);
        return builderAppendPath.build();
    }

    public static U f(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("users").appendPath(fHVar.c).appendPath("subscriptions");
        a(builderAppendPath, 1, 10);
        return U.a(builderAppendPath.build(), fHVar.b);
    }

    public static U g(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("users").appendPath(fHVar.c).appendPath("newsubscriptionvideos");
        a(builderAppendPath);
        return U.a(builderAppendPath.build(), fHVar.b);
    }

    public static U h(fH fHVar) {
        gq.a(fHVar, "userAuth cannot be null");
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("users").appendPath(fHVar.c).appendPath("recommendations");
        a(builderAppendPath);
        return U.a(builderAppendPath.build(), fHVar.b);
    }

    public static U a(W w, String str, String str2, X x) {
        String string = ((W) gq.a(w)).toString();
        Uri.Builder builderAppendPath = b.buildUpon().appendPath("standardfeeds");
        if (!TextUtils.isEmpty(str2)) {
            String upperCase = str2.toUpperCase();
            if (a.contains(upperCase)) {
                builderAppendPath.appendPath(upperCase);
            }
        }
        if (TextUtils.isEmpty(str)) {
            builderAppendPath.appendPath(string);
        } else {
            builderAppendPath.appendPath(string + "_" + str);
        }
        if (x != null) {
            builderAppendPath.appendQueryParameter("time", x.toString());
        }
        a(builderAppendPath);
        return U.a(builderAppendPath.build());
    }

    public static U h(String str) {
        gq.a(str);
        return U.a(b.buildUpon().appendPath("partners").appendPath(str).appendPath("branding").appendPath("default").build());
    }

    public static U a(String str, String str2, boolean z) {
        return U.a(b.buildUpon().appendPath("videos").appendPath(str).appendPath("ratings").build(), str2, ("<?xml version='1.0' encoding='UTF-8'?><entry xmlns='http://www.w3.org/2005/Atom' xmlns:yt='http://gdata.youtube.com/schemas/2007'><yt:rating value='" + (z ? "like" : "dislike") + "'/></entry>").getBytes());
    }

    public static U a(String str, fH fHVar) {
        return U.a(b.buildUpon().appendPath("users").appendPath(fHVar.c).appendPath("favorites").build(), fHVar.b, ("<?xml version='1.0' encoding='UTF-8'?><entry xmlns='http://www.w3.org/2005/Atom'><id>" + str + "</id></entry>").getBytes());
    }

    public static U a(Uri uri, fH fHVar) {
        gq.a(uri, "editUri cannot be null");
        return U.a(uri, fHVar.b);
    }

    public static U b(Uri uri, fH fHVar) {
        gq.a(uri, "editUri cannot be null");
        return U.a(uri, fHVar.b);
    }

    public static U a(String str, Uri uri, fH fHVar) {
        return U.a(uri, fHVar.b, ("<?xml version='1.0' encoding='UTF-8'?><entry xmlns='http://www.w3.org/2005/Atom' xmlns:yt='http://gdata.youtube.com/schemas/2007'><id>" + str + "</id></entry>").getBytes());
    }

    public static U b(String str, fH fHVar) {
        gq.a(str, (Object) "username can't be empty");
        gq.a(fHVar, "userAuth can't be null");
        return U.a(b.buildUpon().appendPath("users").appendPath(fHVar.c).appendPath("subscriptions").build(), fHVar.b, ("<?xml version='1.0' encoding='UTF-8'?><entry xmlns='http://www.w3.org/2005/Atom' xmlns:yt='http://gdata.youtube.com/schemas/2007'><category scheme='http://gdata.youtube.com/schemas/2007/subscriptiontypes.cat' term='user'/><yt:username>" + str + "</yt:username></entry>").getBytes());
    }

    public static U c(String str, fH fHVar) {
        gq.a(str, (Object) "username can't be empty");
        gq.a(fHVar, "userAuth can't be null");
        return U.a(b.buildUpon().appendPath("users").appendPath(fHVar.c).appendPath("subscriptions").build(), fHVar.b, ("<?xml version='1.0' encoding='UTF-8'?><entry xmlns='http://www.w3.org/2005/Atom' xmlns:yt='http://gdata.youtube.com/schemas/2007'><category scheme='http://gdata.youtube.com/schemas/2007/subscriptiontypes.cat' term='channel'/><yt:username>" + str + "</yt:username></entry>").getBytes());
    }

    public static U c(Uri uri, fH fHVar) {
        gq.a(uri, "subscription editUri may not be empty");
        return U.a(uri, fHVar.b);
    }

    private static void a(Uri.Builder builder) {
        b(builder);
        a(builder, 1, 10);
        if (d != null) {
            builder.appendQueryParameter("safeSearch", d.a().toString().toLowerCase());
        }
        if (e != null) {
            builder.appendQueryParameter("restriction", e);
        }
    }

    private static void a(Uri.Builder builder, int i, int i2) {
        builder.appendQueryParameter("start-index", Integer.toString(1));
        builder.appendQueryParameter("max-results", Integer.toString(i2));
    }

    private static void b(Uri.Builder builder) {
        builder.appendQueryParameter("format", "2,3,9");
    }
}
