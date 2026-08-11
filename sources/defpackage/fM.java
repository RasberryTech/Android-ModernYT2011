package defpackage;

import android.net.Uri;
import com.google.android.youtube.YouTubeApplication;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class fM implements Serializable {
    private int A;
    public final String a;
    public final Uri b;
    public final Uri c;
    public final Uri d;
    public final Uri e;
    public final Uri f;
    public final Uri g;
    public final Uri h;
    public final String i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final String n;
    public final Date o;
    public final String p;
    public final String q;
    public final String r;
    public final fO s;
    public final Set t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final Set x;
    private Uri y;
    private Uri z;

    public fM(String str, Uri uri, Uri uri2, Uri uri3, Uri uri4, Uri uri5, Uri uri6, Uri uri7, Uri uri8, Uri uri9, String str2, int i, int i2, int i3, int i4, int i5, String str3, Date date, String str4, String str5, String str6, boolean z, fO fOVar, Set set, boolean z2, boolean z3, Set set2) {
        this.a = gq.a(str, (Object) "youTubeId can't be empty");
        this.y = uri;
        this.b = uri2;
        this.c = uri3;
        this.d = uri4;
        this.e = uri5;
        this.f = uri6;
        this.g = uri7;
        this.z = uri8;
        this.h = uri9;
        this.i = str2;
        this.j = i;
        this.k = i2;
        this.A = i3;
        this.l = i4;
        this.m = i5;
        this.n = str3;
        this.o = date;
        this.p = str4;
        this.q = str5;
        this.r = str6;
        this.u = z;
        this.s = (fO) gq.a(fOVar, "state can't be null");
        this.t = set;
        this.v = z2;
        this.w = z3;
        this.x = set2;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof fM) && this.a != null) {
            return this.a.equals(((fM) obj).a);
        }
        return false;
    }

    public final String toString() {
        return "Video[id = '" + this.a + "', title='" + this.i + "']";
    }

    public final boolean a() {
        return !YouTubeApplication.a && "Music".equals(this.p);
    }

    public final Uri a(boolean z) {
        Uri uri = this.b;
        Uri uri2 = this.y;
        if (z) {
            return uri != null ? uri : uri2;
        }
        return uri2 != null ? uri2 : uri;
    }

    private Object writeReplace() {
        return new fN().a(this.a).a(this.y).b(this.b).c(this.c).d(this.d).e(this.e).f(this.f).g(this.g).h(this.z).i(this.h).b(this.i).a(this.j).b(this.k).c(this.A).d(this.l).e(this.m).c(this.n).a(this.o).d(this.p).e(this.q).f(this.r).a(this.u).a(this.s).a(this.t).b(this.v).c(this.w).b(this.x);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("builder required");
    }
}
