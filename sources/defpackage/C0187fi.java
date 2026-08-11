package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: fi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0187fi implements Serializable {
    public final String a;
    public final String b;
    public final String c;

    public C0187fi(String str, String str2, String str3) {
        this.a = (String) gq.a((Object) str, (Object) "id may not be null");
        this.b = (String) gq.a((Object) str2, (Object) "name may not be null");
        this.c = (String) gq.a((Object) str3, (Object) "biography may not be null");
    }
}
