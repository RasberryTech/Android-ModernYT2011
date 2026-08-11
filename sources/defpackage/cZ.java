package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class cZ {
    private static cZ a = null;
    private String b;
    private String c;

    private cZ(String str) {
        String strD = d(str);
        String strD2 = d(System.getProperty("microedition.locale"));
        if (!"en".equals(strD2) && (strD2.length() != 2 || !strD.startsWith(strD2))) {
            strD = strD2;
        }
        b(strD);
        c(C0161ej.a("en", (String) null));
    }

    public static cZ a(String str) {
        cZ cZVar = new cZ(str);
        a = cZVar;
        return cZVar;
    }

    private static String d(String str) {
        if (str == null) {
            return "en";
        }
        String[] strArrA = C0160ei.a(str.replace('-', '_'), '_');
        if (strArrA[0].length() != 2 && strArrA[0].length() != 3) {
            return "en";
        }
        String lowerCase = strArrA[0].toLowerCase();
        return (strArrA.length < 2 || strArrA[1].length() != 2) ? lowerCase : lowerCase + "_" + strArrA[1].toUpperCase();
    }

    public final void b(String str) {
        this.b = d(str);
        int iIndexOf = this.b.indexOf(95);
        if (iIndexOf >= 0) {
            this.b.substring(0, iIndexOf);
        }
    }

    public final void c(String str) {
        this.c = str != null ? d(str) : this.b;
        String str2 = this.c;
        int iIndexOf = str2.indexOf(95);
        if (iIndexOf < 0) {
            iIndexOf = str2.indexOf(45);
        }
        if (iIndexOf < 0) {
            return;
        }
        str2.substring(0, iIndexOf);
    }
}
