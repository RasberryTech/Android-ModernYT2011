package defpackage;

import android.net.Uri;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: renamed from: fl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0190fl implements Serializable {
    public final Uri a;
    public final Uri b;
    private String c;
    private String d;
    private String e;

    public C0190fl(String str, String str2, String str3, Uri uri, Uri uri2) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.a = uri;
        this.b = uri2;
    }

    private Object writeReplace() {
        return new C0191fm().a(this.c).b(this.d).c(this.e).a(this.a).b(this.b);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("builder required");
    }
}
