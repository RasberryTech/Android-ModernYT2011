package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class fN implements Serializable {
    private Set A;
    private String a;
    private Uri b;
    private Uri c;
    private Uri d;
    private Uri e;
    private Uri f;
    private Uri g;
    private Uri h;
    private Uri i;
    private Uri j;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private String q;
    private Date r;
    private String s;
    private String t;
    private String u;
    private boolean v;
    private fO w = fO.PLAYABLE;
    private Set x;
    private boolean y;
    private boolean z;

    public final fM a() {
        return new fM(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A);
    }

    public final fN a(String str) {
        this.a = str;
        return this;
    }

    public final Uri b() {
        return this.b;
    }

    public final fN a(Uri uri) {
        this.b = uri;
        return this;
    }

    public final fN b(Uri uri) {
        this.c = uri;
        return this;
    }

    public final fN c(Uri uri) {
        this.d = uri;
        return this;
    }

    public final fN d(Uri uri) {
        this.e = uri;
        return this;
    }

    public final fN e(Uri uri) {
        this.f = uri;
        return this;
    }

    public final fN f(Uri uri) {
        this.g = uri;
        return this;
    }

    public final fN g(Uri uri) {
        this.h = uri;
        return this;
    }

    public final fN h(Uri uri) {
        this.i = uri;
        return this;
    }

    public final fN i(Uri uri) {
        this.j = uri;
        return this;
    }

    public final fN b(String str) {
        this.k = str;
        return this;
    }

    public final fN a(int i) {
        this.l = i;
        return this;
    }

    public final fN b(int i) {
        this.m = i;
        return this;
    }

    public final fN c(int i) {
        this.n = i;
        return this;
    }

    public final fN d(int i) {
        this.o = i;
        return this;
    }

    public final fN e(int i) {
        this.p = i;
        return this;
    }

    public final fN c(String str) {
        this.q = str;
        return this;
    }

    public final fN a(Date date) {
        this.r = date;
        return this;
    }

    public final Date c() {
        return this.r;
    }

    public final fN d(String str) {
        this.s = str;
        return this;
    }

    public final fN e(String str) {
        this.t = str;
        return this;
    }

    public final fN f(String str) {
        this.u = str;
        return this;
    }

    public final fN a(boolean z) {
        this.v = z;
        return this;
    }

    public final fN a(fO fOVar) {
        this.w = (fO) gq.a(fOVar, "state can't be null");
        return this;
    }

    public final fN a(Set set) {
        this.x = set;
        return this;
    }

    public final fN b(boolean z) {
        this.y = z;
        return this;
    }

    public final fN c(boolean z) {
        this.z = z;
        return this;
    }

    public final fN b(Set set) {
        this.A = set;
        return this;
    }

    private Object readResolve() {
        return a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.a);
        objectOutputStream.writeObject(gv.a(this.b));
        objectOutputStream.writeObject(gv.a(this.c));
        objectOutputStream.writeObject(gv.a(this.d));
        objectOutputStream.writeObject(gv.a(this.e));
        objectOutputStream.writeObject(gv.a(this.f));
        objectOutputStream.writeObject(gv.a(this.g));
        objectOutputStream.writeObject(gv.a(this.h));
        objectOutputStream.writeObject(gv.a(this.i));
        objectOutputStream.writeObject(gv.a(this.j));
        objectOutputStream.writeObject(this.k);
        objectOutputStream.writeInt(this.l);
        objectOutputStream.writeInt(this.m);
        objectOutputStream.writeInt(this.n);
        objectOutputStream.writeInt(this.o);
        objectOutputStream.writeInt(this.p);
        objectOutputStream.writeObject(this.q);
        objectOutputStream.writeObject(this.r);
        objectOutputStream.writeObject(this.s);
        objectOutputStream.writeObject(this.t);
        objectOutputStream.writeObject(this.u);
        objectOutputStream.writeBoolean(this.v);
        objectOutputStream.writeObject(this.w);
        objectOutputStream.writeObject(this.x);
        objectOutputStream.writeBoolean(this.y);
        objectOutputStream.writeBoolean(this.z);
        objectOutputStream.writeObject(this.A);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.a = (String) objectInputStream.readObject();
        this.b = gv.a((String) objectInputStream.readObject());
        this.c = gv.a((String) objectInputStream.readObject());
        this.d = gv.a((String) objectInputStream.readObject());
        this.e = gv.a((String) objectInputStream.readObject());
        this.f = gv.a((String) objectInputStream.readObject());
        this.g = gv.a((String) objectInputStream.readObject());
        this.h = gv.a((String) objectInputStream.readObject());
        this.i = gv.a((String) objectInputStream.readObject());
        this.j = gv.a((String) objectInputStream.readObject());
        this.k = (String) objectInputStream.readObject();
        this.l = objectInputStream.readInt();
        this.m = objectInputStream.readInt();
        this.n = objectInputStream.readInt();
        this.o = objectInputStream.readInt();
        this.p = objectInputStream.readInt();
        this.q = (String) objectInputStream.readObject();
        this.r = (Date) objectInputStream.readObject();
        this.s = (String) objectInputStream.readObject();
        this.t = (String) objectInputStream.readObject();
        this.u = (String) objectInputStream.readObject();
        this.v = objectInputStream.readBoolean();
        this.w = (fO) objectInputStream.readObject();
        this.x = (Set) objectInputStream.readObject();
        this.y = objectInputStream.readBoolean();
        this.z = objectInputStream.readBoolean();
        this.A = (Set) objectInputStream.readObject();
    }
}
