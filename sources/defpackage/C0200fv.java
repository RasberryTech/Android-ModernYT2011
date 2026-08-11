package defpackage;

import android.net.Uri;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: fv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0200fv implements Serializable, Iterable {
    public final int a;
    public final int b;
    public final Uri c;
    public final List d;
    private int e;
    private Uri f;

    public C0200fv(int i, int i2, int i3, Uri uri, Uri uri2, List list) {
        this.a = i;
        this.e = i2;
        this.b = i3;
        this.f = uri;
        this.c = uri2;
        this.d = (List) gq.a(list);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.d.iterator();
    }

    private Object writeReplace() {
        return new C0201fw().a(this.a).b(this.e).c(this.b).a(this.f).b(this.c).a(this.d);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("builder required");
    }
}
