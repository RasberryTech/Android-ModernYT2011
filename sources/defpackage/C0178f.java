package defpackage;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

/* JADX INFO: renamed from: f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0178f implements SocketFactory {
    private SocketFactory a;
    private /* synthetic */ C0054c b;

    /* synthetic */ C0178f(C0054c c0054c, SocketFactory socketFactory) {
        this(c0054c, socketFactory, (byte) 0);
    }

    private C0178f(C0054c c0054c, SocketFactory socketFactory, byte b) {
        this.b = c0054c;
        this.a = socketFactory;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final Socket createSocket() {
        return this.a.createSocket();
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final boolean isSecure(Socket socket) {
        return this.a.isSecure(socket);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        this.b.d.set(Boolean.TRUE);
        return this.a.connectSocket(socket, str, i, inetAddress, i2, httpParams);
    }
}
