package defpackage;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class fG implements Serializable {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    private String e;

    public fG(String str, String str2, String str3) {
        this.a = (String) gq.a((Object) str);
        this.b = str;
        this.e = (String) gq.a((Object) str2);
        this.c = (String) gq.a((Object) str3);
        this.d = null;
    }

    public fG(String str, String str2, String str3, String str4) {
        this.a = (String) gq.a((Object) str);
        this.b = (String) gq.a((Object) str2);
        this.e = null;
        this.c = (String) gq.a((Object) str3);
        this.d = (String) gq.a((Object) str4);
    }

    public fG(fG fGVar, String str) {
        this.a = fGVar.a;
        this.b = fGVar.b;
        this.e = fGVar.e;
        this.c = fGVar.c;
        this.d = (String) gq.a((Object) str);
    }

    public final boolean a() {
        return !this.b.equals(this.a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(" - ").append(this.c);
        }
        if (a()) {
            sb.append("*");
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof fG)) {
            return false;
        }
        fG fGVar = (fG) obj;
        return this.a.equals(fGVar.a) && this.b.equals(fGVar.b) && this.c.equals(fGVar.c) && ((this.d == null && fGVar.d == null) || this.d.equals(fGVar.d));
    }

    public final int hashCode() {
        int iHashCode = (((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d != null) {
            return iHashCode + this.d.hashCode();
        }
        return iHashCode;
    }
}
