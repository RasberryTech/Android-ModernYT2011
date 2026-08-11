package defpackage;

import java.io.Serializable;
import java.util.Date;

/* JADX INFO: renamed from: fq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0195fq implements Serializable {
    public final String a;
    public final EnumC0196fr b;
    public final String c;
    public final Date d;

    public C0195fq(String str, EnumC0196fr enumC0196fr, String str2, Date date) {
        this.a = str;
        this.b = enumC0196fr;
        this.c = str2;
        this.d = date;
    }

    public final String toString() {
        return this.a + " " + this.b.toString().toLowerCase() + " " + this.c;
    }
}
