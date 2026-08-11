package defpackage;

/* JADX INFO: renamed from: j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0218j implements Comparable {
    public static final C0218j c = new C0218j();
    public final String a;
    public final String b;
    private String d;
    private boolean e;

    public C0218j(String str, String str2) throws C0219k {
        boolean z = false;
        this.a = str;
        String[] strArrSplit = C0217i.a.split(str2);
        if (strArrSplit.length == 0) {
            throw new C0219k("Empty rule");
        }
        this.b = strArrSplit[0];
        String str3 = null;
        int i = 1;
        while (i < strArrSplit.length) {
            String lowerCase = strArrSplit[i].toLowerCase();
            if (lowerCase.equals("rewrite") && i + 1 < strArrSplit.length) {
                str3 = strArrSplit[i + 1];
                i += 2;
            } else if (lowerCase.equals("block")) {
                i++;
                z = true;
            } else {
                throw new C0219k("Illegal rule: " + str2);
            }
        }
        this.d = str3;
        this.e = z;
    }

    private C0218j() {
        this.a = "DEFAULT";
        this.b = "";
        this.d = null;
        this.e = false;
    }

    public final String a(String str) {
        if (this.e) {
            return null;
        }
        return this.d != null ? this.d + str.substring(this.b.length()) : str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return ((C0218j) obj).b.compareTo(this.b);
    }
}
