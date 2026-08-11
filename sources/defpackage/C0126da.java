package defpackage;

import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: renamed from: da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0126da {
    private static final Object a;
    private static String b;

    static {
        System.currentTimeMillis();
        new Vector(150);
        new Hashtable();
        a = new Object();
        b = null;
        new StringBuffer(256);
        new C0127db();
    }

    private C0126da() {
    }

    public static synchronized void a() {
    }

    public static void a(String str, Throwable th) {
        th.printStackTrace();
        String str2 = str + ": " + th.toString();
        if (str2 != null) {
            synchronized (a) {
                if (b == null) {
                    b = str2;
                } else {
                    b += "\n" + str2;
                }
                if (b.length() > 300) {
                    b = b.substring(0, 300);
                }
            }
        }
    }

    public static void b(String str, Throwable th) {
        th.printStackTrace();
    }
}
