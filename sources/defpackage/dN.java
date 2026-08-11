package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

/* JADX INFO: loaded from: classes.dex */
final class dN implements InterfaceC0146dv {
    private final HttpUriRequest a;
    private ByteArrayOutputStream b;
    private HttpResponse c;
    private boolean d;
    private /* synthetic */ dM e;

    /* synthetic */ dN(dM dMVar, String str, boolean z) {
        this(dMVar, str, z, (byte) 0);
    }

    private dN(dM dMVar, String str, boolean z, byte b) throws IOException {
        this.e = dMVar;
        this.b = null;
        this.c = null;
        try {
            if (!z) {
                throw new UnsupportedOperationException("GET not supported:" + str);
            }
            this.a = new HttpPost(str);
            synchronized (dM.e) {
                dM.b();
            }
        } catch (RuntimeException e) {
            IOException iOException = new IOException("URISyntaxException in HttpUriRequest, post=" + z + ", url=" + str);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private HttpResponse g() throws IOException {
        if (this.c == null) {
            if (this.b != null) {
                ((HttpPost) this.a).setEntity(new ByteArrayEntity(this.b.toByteArray()));
            }
            try {
                this.c = this.e.c.execute(this.a);
            } catch (IOException e) {
                throw e;
            }
        }
        return this.c;
    }

    @Override // defpackage.InterfaceC0146dv
    public final DataOutputStream a() throws IOException {
        if (!(this.a instanceof HttpPost)) {
            throw new IOException("Can't open output stream on a GET to " + this.a.getURI());
        }
        this.b = new ByteArrayOutputStream();
        return new DataOutputStream(this.b);
    }

    @Override // defpackage.InterfaceC0146dv
    public final void a(String str, String str2) {
        if ("Content-Length".equals(str) || "Transfer-Encoding".equals(str)) {
            return;
        }
        this.a.setHeader(str, str2);
    }

    @Override // defpackage.InterfaceC0146dv
    public final DataInputStream b() {
        return new DataInputStream(g().getEntity().getContent());
    }

    @Override // defpackage.InterfaceC0146dv
    public final int c() {
        return g().getStatusLine().getStatusCode();
    }

    @Override // defpackage.InterfaceC0146dv
    public final String d() {
        Header contentType = g().getEntity().getContentType();
        return contentType == null ? "" : contentType.getValue();
    }

    @Override // defpackage.InterfaceC0146dv
    public final long e() {
        return g().getEntity().getContentLength();
    }

    @Override // defpackage.InterfaceC0146dv
    public final void f() throws IOException {
        HttpEntity entity;
        if (this.c != null && (entity = this.c.getEntity()) != null) {
            entity.consumeContent();
        }
        synchronized (dM.e) {
            if (this.d) {
                return;
            }
            this.d = true;
            dM.c();
            String str = "Connection closed.  # of open connections=" + dM.d;
        }
    }
}
