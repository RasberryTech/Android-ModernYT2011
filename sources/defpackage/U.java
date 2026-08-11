package defpackage;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class U {
    public final Uri a;
    public final String b;
    public final byte[] c;
    private volatile int d;

    private U(Uri uri, String str, byte[] bArr) {
        gq.a(uri, "uri can't be null");
        this.a = uri;
        this.b = str;
        this.c = bArr;
    }

    public static U a(Uri uri) {
        return new U(uri, null, null);
    }

    public static U a(Uri uri, String str) {
        gq.a((Object) str, (Object) "authToken can't be null");
        return new U(uri, str, null);
    }

    public static U a(Uri uri, String str, byte[] bArr) {
        gq.a((Object) str, (Object) "authToken can't be null");
        gq.a(bArr, "content can't be null");
        return new U(uri, str, bArr);
    }

    public static U a(Uri uri, U u) {
        gq.a(u, "template can't be null");
        return new U(uri, u.b, a(u));
    }

    public static U a(String str, U u) {
        gq.a(u, "template can't be null");
        return new U(u.a, str, a(u));
    }

    private static byte[] a(U u) {
        if (u.c == null) {
            return null;
        }
        int length = u.c.length;
        byte[] bArr = new byte[length];
        System.arraycopy(u.c, 0, bArr, 0, length);
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof U)) {
            return false;
        }
        U u = (U) obj;
        return (this.b == null) == (u.b == null) && this.a.equals(u.a) && Arrays.equals(this.c, u.c);
    }

    public final int hashCode() {
        int i = this.d;
        if (i == 0) {
            int iHashCode = (((((this.a == null ? 0 : this.a.hashCode()) + 527) * 31) + (this.b == null ? 0 : 49)) * 31) + (this.c == null ? 0 : Arrays.hashCode(this.c));
            this.d = iHashCode;
            return iHashCode;
        }
        return i;
    }

    public final String toString() {
        return "uri=[" + this.a + "], authToken=[" + this.b + "], content=[" + (this.c != null ? new String(this.c) : "null") + "]";
    }
}
