package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class fH {
    public final String a;
    public final String b;
    public final String c;

    public fH(String str, String str2, String str3) {
        this.b = str2;
        int iIndexOf = str.indexOf("@");
        if (iIndexOf >= 0) {
            this.a = str;
            this.c = str3 != null ? str3 : str.substring(0, iIndexOf);
        } else {
            this.a = str + "@youtube.com";
            this.c = str3 != null ? str3 : str;
        }
    }
}
