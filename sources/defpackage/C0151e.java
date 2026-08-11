package defpackage;

import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;

/* JADX INFO: renamed from: e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0151e extends C0178f implements LayeredSocketFactory {
    private LayeredSocketFactory a;

    /* synthetic */ C0151e(C0054c c0054c, LayeredSocketFactory layeredSocketFactory) {
        this(c0054c, layeredSocketFactory, (byte) 0);
    }

    private C0151e(C0054c c0054c, LayeredSocketFactory layeredSocketFactory, byte b) {
        super(c0054c, layeredSocketFactory);
        this.a = layeredSocketFactory;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.createSocket(socket, str, i, z);
    }
}
