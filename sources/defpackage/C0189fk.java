package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: fk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0189fk implements Serializable {
    public final String a;
    public final String b;

    public C0189fk(String str, String str2) {
        this.a = (String) gq.a((Object) str, (Object) "id may not be null");
        this.b = (String) gq.a((Object) str2, (Object) "name may not be null");
    }
}
