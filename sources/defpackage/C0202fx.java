package defpackage;

import android.net.Uri;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: renamed from: fx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0202fx implements Serializable {
    public final String a;
    public final String b;
    public final String c;
    public final Uri d;
    public final int e;
    private Date f;

    public C0202fx(String str, String str2, String str3, Date date, Uri uri, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f = date;
        this.d = uri;
        this.e = i;
    }

    public final String toString() {
        return this.a;
    }

    private Object writeReplace() {
        return new C0203fy().a(this.a).b(this.b).c(this.c).a(this.f).a(this.d).a(this.e);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("builder required");
    }
}
