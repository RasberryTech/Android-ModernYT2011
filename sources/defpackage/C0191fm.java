package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: renamed from: fm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0191fm implements Serializable {
    private String a;
    private String b;
    private String c;
    private Uri d;
    private Uri e;

    public final C0191fm a(String str) {
        this.a = str;
        return this;
    }

    public final C0191fm b(String str) {
        this.b = str;
        return this;
    }

    public final C0191fm c(String str) {
        this.c = str;
        return this;
    }

    public final C0191fm a(Uri uri) {
        this.d = uri;
        return this;
    }

    public final C0191fm b(Uri uri) {
        this.e = uri;
        return this;
    }

    public final C0190fl a() {
        return new C0190fl(this.a, this.b, this.c, this.d, this.e);
    }

    private Object readResolve() {
        return a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.a);
        objectOutputStream.writeObject(this.b);
        objectOutputStream.writeObject(this.c);
        objectOutputStream.writeObject(gv.a(this.d));
        objectOutputStream.writeObject(gv.a(this.e));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.a = (String) objectInputStream.readObject();
        this.b = (String) objectInputStream.readObject();
        this.c = (String) objectInputStream.readObject();
        this.d = gv.a((String) objectInputStream.readObject());
        this.e = gv.a((String) objectInputStream.readObject());
    }
}
