package defpackage;

/* JADX INFO: renamed from: ei, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0160ei {
    static {
        new Boolean(true);
        new Boolean(false);
    }

    private C0160ei() {
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static String[] a(String str, char c) {
        String strValueOf = String.valueOf('_');
        int length = str.length();
        int iIndexOf = str.indexOf(strValueOf, 0);
        int i = 0;
        while (iIndexOf != -1 && iIndexOf < length) {
            i++;
            if (iIndexOf >= 0) {
                iIndexOf += strValueOf.length();
            }
            iIndexOf = str.indexOf(strValueOf, iIndexOf);
        }
        String[] strArr = new String[i + 1];
        int length2 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            int iIndexOf2 = str.indexOf(strValueOf, length2);
            strArr[i2] = str.substring(length2, iIndexOf2);
            length2 = strValueOf.length() + iIndexOf2;
        }
        strArr[i] = str.substring(length2);
        return strArr;
    }
}
