package defpackage;

/* JADX INFO: renamed from: ej, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0161ej {
    private C0161ej() {
    }

    public static Object a(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("No public default constructor for class " + cls.getName());
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot instantiate instance of class " + cls.getName());
        }
    }

    public static String a(String str, String str2) {
        return a(str) ? str : str2;
    }

    public static boolean a(String str) {
        return !str.startsWith("${");
    }

    public static boolean a(String str, boolean z) {
        String strA = a(str, (String) null);
        if (strA != null) {
            String lowerCase = strA.toLowerCase();
            if (lowerCase.equals("true")) {
                return true;
            }
            if (lowerCase.equals("false")) {
                return false;
            }
        }
        return false;
    }
}
