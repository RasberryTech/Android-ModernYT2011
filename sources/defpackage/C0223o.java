package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0223o {
    private static ContentResolver c;
    private static HashMap d;
    private static Object e;
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    private static Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern f = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern g = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    private static void b(ContentResolver contentResolver) {
        if (d == null) {
            d = new HashMap();
            e = new Object();
            c = contentResolver;
            new C0224p(contentResolver).start();
        }
    }

    private static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (C0223o.class) {
            b(contentResolver);
            Object obj = e;
            if (d.containsKey(str)) {
                String str3 = (String) d.get(str);
                return str3 != null ? str3 : null;
            }
            Cursor cursorQuery = c.query(a, null, null, new String[]{str}, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(1);
                synchronized (C0223o.class) {
                    try {
                        if (obj == e) {
                            d.put(str, string);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (string == null) {
                    string = null;
                }
                cursorQuery.close();
                return string;
            } catch (Throwable th2) {
                cursorQuery.close();
                throw th2;
            }
        }
    }

    public static String a(ContentResolver contentResolver, String str) {
        return a(contentResolver, str, (String) null);
    }

    public static long a(ContentResolver contentResolver, String str, long j) {
        String strA = a(contentResolver, str, (String) null);
        if (strA == null) {
            return 43200000L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException e2) {
            return 43200000L;
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z) {
        String strA = a(contentResolver, str, (String) null);
        if (strA == null || strA.equals("")) {
            return false;
        }
        if (f.matcher(strA).matches()) {
            return true;
        }
        if (g.matcher(strA).matches()) {
            return false;
        }
        Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + strA + "\") as boolean");
        return false;
    }

    public static Map a(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery == null) {
            return treeMap;
        }
        while (cursorQuery.moveToNext()) {
            try {
                treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return treeMap;
    }

    public static Object a(ContentResolver contentResolver) {
        Object obj;
        synchronized (C0223o.class) {
            b(contentResolver);
            obj = e;
        }
        return obj;
    }
}
