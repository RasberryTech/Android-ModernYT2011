package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: renamed from: fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0203fy implements Serializable {
    private String a;
    private String b;
    private String c;
    private Date d;
    private Uri e;
    private int f;

    public final C0203fy a(String str) {
        this.a = str;
        return this;
    }

    public final C0203fy b(String str) {
        this.b = str;
        return this;
    }

    public final C0203fy c(String str) {
        this.c = str;
        return this;
    }

    public final C0203fy a(Date date) {
        this.d = date;
        return this;
    }

    public final C0203fy a(Uri uri) {
        this.e = uri;
        return this;
    }

    public final C0203fy a(int i) {
        this.f = i;
        return this;
    }

    public final C0202fx a() {
        return new C0202fx(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    private Object readResolve() {
        return a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.a);
        objectOutputStream.writeObject(this.b);
        objectOutputStream.writeObject(this.c);
        objectOutputStream.writeObject(this.d);
        objectOutputStream.writeObject(gv.a(this.e));
        objectOutputStream.writeInt(this.f);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.a = (String) objectInputStream.readObject();
        this.b = (String) objectInputStream.readObject();
        this.c = (String) objectInputStream.readObject();
        this.d = (Date) objectInputStream.readObject();
        this.e = gv.a((String) objectInputStream.readObject());
        this.f = objectInputStream.readInt();
    }
}
