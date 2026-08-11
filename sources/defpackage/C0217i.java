package defpackage;

import android.content.ContentResolver;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0217i {
    private static final Pattern a = Pattern.compile(" +");
    private static final Pattern b = Pattern.compile("\\W");
    private static C0217i c = new C0217i(new C0218j[0]);
    private static Object d;
    private final C0218j[] e;
    private final Pattern f;

    private C0217i(C0218j[] c0218jArr) {
        Arrays.sort(c0218jArr);
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < c0218jArr.length; i++) {
            if (i > 0) {
                sb.append(")|(");
            }
            sb.append(b.matcher(c0218jArr[i].b).replaceAll("\\\\$0"));
        }
        this.f = Pattern.compile(sb.append(")").toString());
        this.e = c0218jArr;
    }

    public final C0218j a(String str) {
        Matcher matcher = this.f.matcher(str);
        if (matcher.lookingAt()) {
            for (int i = 0; i < this.e.length; i++) {
                if (matcher.group(i + 1) != null) {
                    return this.e[i];
                }
            }
        }
        return C0218j.c;
    }

    public static synchronized C0217i a(ContentResolver contentResolver) {
        C0217i c0217i;
        try {
            Object objA = C0223o.a(contentResolver);
            if (objA == d) {
                if (Log.isLoggable("UrlRules", 2)) {
                    Log.v("UrlRules", "Using cached rules, versionToken: " + objA);
                }
                c0217i = c;
            } else {
                if (Log.isLoggable("UrlRules", 2)) {
                    Log.v("UrlRules", "Scanning for Gservices \"url:*\" rules");
                }
                Map mapA = C0223o.a(contentResolver, "url:");
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : mapA.entrySet()) {
                    try {
                        String strSubstring = ((String) entry.getKey()).substring(4);
                        String str = (String) entry.getValue();
                        if (str != null && str.length() != 0) {
                            if (Log.isLoggable("UrlRules", 2)) {
                                Log.v("UrlRules", "  Rule " + strSubstring + ": " + str);
                            }
                            arrayList.add(new C0218j(strSubstring, str));
                        }
                    } catch (C0219k e) {
                        Log.e("UrlRules", "Invalid rule from Gservices", e);
                    }
                }
                c = new C0217i((C0218j[]) arrayList.toArray(new C0218j[arrayList.size()]));
                d = objA;
                if (Log.isLoggable("UrlRules", 2)) {
                    Log.v("UrlRules", "New rules stored, versionToken: " + objA);
                }
                c0217i = c;
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0217i;
    }
}
