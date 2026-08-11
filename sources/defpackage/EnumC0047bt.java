package defpackage;

import android.net.Uri;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: bt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnumC0047bt {
    public static final EnumC0047bt a;
    public static final EnumC0047bt b;
    public static final EnumC0047bt c;
    private static EnumC0047bt d;
    private static final /* synthetic */ EnumC0047bt[] e;

    public abstract HttpUriRequest a(Uri uri);

    /* synthetic */ EnumC0047bt(String str, int i) {
        this(str, i, (byte) 0);
    }

    private EnumC0047bt(String str, int i, byte b2) {
        super(str, i);
    }

    public static EnumC0047bt valueOf(String str) {
        return (EnumC0047bt) Enum.valueOf(EnumC0047bt.class, str);
    }

    public static EnumC0047bt[] values() {
        return (EnumC0047bt[]) e.clone();
    }

    static {
        final int i = 3;
        final int i2 = 2;
        final int i3 = 1;
        final int i4 = 0;
        final String str = "GET";
        a = new EnumC0047bt(str, i4) { // from class: bu
            {
                int i5 = 0;
            }

            @Override // defpackage.EnumC0047bt
            public final HttpUriRequest a(Uri uri) {
                return new HttpGet(uri.toString());
            }
        };
        final String str2 = "POST";
        b = new EnumC0047bt(str2, i3) { // from class: bv
            {
                int i5 = 1;
            }

            @Override // defpackage.EnumC0047bt
            public final HttpUriRequest a(Uri uri) {
                return new HttpPost(uri.toString());
            }
        };
        final String str3 = "PUT";
        d = new EnumC0047bt(str3, i2) { // from class: bw
            {
                int i5 = 2;
            }

            @Override // defpackage.EnumC0047bt
            public final HttpUriRequest a(Uri uri) {
                return new HttpPut(uri.toString());
            }
        };
        final String str4 = "DELETE";
        c = new EnumC0047bt(str4, i) { // from class: bx
            {
                int i5 = 3;
            }

            @Override // defpackage.EnumC0047bt
            public final HttpUriRequest a(Uri uri) {
                return new HttpDelete(uri.toString());
            }
        };
        e = new EnumC0047bt[]{a, b, d, c};
    }

    public final boolean a() {
        return this == b || this == d;
    }
}
