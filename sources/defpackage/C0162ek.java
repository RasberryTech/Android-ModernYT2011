package defpackage;

import java.util.Hashtable;

/* JADX INFO: renamed from: ek, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0162ek {
    private static final String[] a;
    private static final AbstractC0163el b;

    static {
        new Hashtable();
        a = new String[]{"ALL", "FINEST", "FINER", "FINE", "CONFIG", "INFO", "WARNING", "SEVERE", "NONE"};
        b = (AbstractC0163el) C0161ej.a(c());
    }

    private C0162ek() {
    }

    public static int a(int i) {
        String strA = C0161ej.a("INFO", System.getProperty("LOG_LEVEL"));
        if (strA == null) {
            System.err.println("WARNING: Missing log level - using logger specific default");
            System.err.println("         For Ant: Specify the log level using the LOG_LEVEL property");
            System.err.println("         For Bolide: Specify the log level using constant injection");
            System.err.println("         For J2SE:  Define LOG_LEVEL system property");
            System.err.println("         See JavaDoc or source of com.google.debug.Log.");
        }
        if (strA == null) {
            return 5;
        }
        String upperCase = strA.toUpperCase();
        for (int i2 = 0; i2 <= 8; i2++) {
            if (upperCase.equals(a[i2])) {
                return i2;
            }
        }
        throw new IllegalArgumentException("Invalid log level " + upperCase);
    }

    public static void a(Object obj, Throwable th) {
        b.a(obj, th, 5, null, null, -1);
    }

    public static boolean a() {
        return C0161ej.a("false", false);
    }

    public static String b(int i) {
        return a[i];
    }

    public static boolean b() {
        return C0161ej.a("true", false);
    }

    private static Class c() {
        try {
            if (C0161ej.a("em")) {
                return Class.forName("em");
            }
            String property = System.getProperty("LOGGER");
            if (property != null) {
                return Class.forName(property);
            }
            System.err.println("WARNING: Missing logger class - using default logger com.google.debug.StdoutLogger");
            System.err.println("         For Ant: Specify the logger class using the LOGGER property");
            System.err.println("         For Bolide: Specify the logger class using constant injection");
            System.err.println("         For J2SE:  Specify the logger class via the LOGGER system property");
            System.err.println("         See JavaDoc or source of com.google.debug.Log.");
            return Class.forName("em");
        } catch (ClassNotFoundException e) {
            throw new Error("Missing logger class com.google.debug.StdoutLogger");
        }
    }
}
