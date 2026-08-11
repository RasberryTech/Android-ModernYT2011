package defpackage;

import android.net.Uri;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: renamed from: fz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0204fz implements Serializable {
    public final String a;
    public final fC b;
    public final Uri c;
    public final Uri d;

    public C0204fz(String str, fC fCVar, Uri uri, Uri uri2) {
        gq.a((Object) str);
        gq.a(fCVar);
        gq.a(uri);
        gq.a(uri2);
        this.d = uri2;
        this.a = str;
        this.b = fCVar;
        this.c = uri;
    }

    private Object writeReplace() {
        return new fB().a(this.a).a(this.b).a(this.c).b(this.d);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("builder required");
    }

    public final String toString() {
        return this.a;
    }
}
