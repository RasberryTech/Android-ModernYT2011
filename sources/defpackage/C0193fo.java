package defpackage;

import java.io.Serializable;
import java.util.Date;

/* JADX INFO: renamed from: fo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0193fo implements Serializable {
    public final String a;
    public final String b;
    public final Date c;

    public C0193fo(String str, String str2, String str3, Date date) {
        this.a = str2;
        this.b = str3;
        this.c = date;
    }

    public final String toString() {
        return this.a;
    }
}
