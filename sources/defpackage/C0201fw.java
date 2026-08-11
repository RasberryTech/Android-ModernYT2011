package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: fw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0201fw implements Serializable {
    private int a;
    private int b;
    private int c;
    private Uri d;
    private Uri e;
    private List f = new LinkedList();

    public final C0201fw a(int i) {
        this.a = i;
        return this;
    }

    public final C0201fw b(int i) {
        this.b = i;
        return this;
    }

    public final C0201fw c(int i) {
        this.c = i;
        return this;
    }

    public final C0201fw a(Uri uri) {
        this.d = uri;
        return this;
    }

    public final C0201fw b(Uri uri) {
        this.e = uri;
        return this;
    }

    public final C0201fw a(List list) {
        gq.a(list, "entries can't be null");
        this.f.addAll(list);
        return this;
    }

    public final C0201fw a(Object obj) {
        this.f.add(obj);
        return this;
    }

    public final C0200fv a() {
        return new C0200fv(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    private Object readResolve() {
        return a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.a);
        objectOutputStream.writeInt(this.b);
        objectOutputStream.writeInt(this.c);
        objectOutputStream.writeObject(gv.a(this.d));
        objectOutputStream.writeObject(gv.a(this.e));
        objectOutputStream.writeObject(this.f);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.a = objectInputStream.readInt();
        this.b = objectInputStream.readInt();
        this.c = objectInputStream.readInt();
        this.d = gv.a((String) objectInputStream.readObject());
        this.e = gv.a((String) objectInputStream.readObject());
        this.f = (List) objectInputStream.readObject();
    }
}
