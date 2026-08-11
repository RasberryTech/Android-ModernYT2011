package defpackage;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public final class dH implements HttpClient {
    private static final ThreadLocal a = new ThreadLocal();
    private static final HttpRequestInterceptor b = new dI();
    private final HttpClient c;
    private RuntimeException d = new IllegalStateException("AndroidHttpClient_v09 created and never closed");

    private dH(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.c = new dJ(this, clientConnectionManager, httpParams);
    }

    public static dH a(String str) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new dH(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    static /* synthetic */ dL a(dH dHVar) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0097  */
    static /* synthetic */ String a(HttpUriRequest httpUriRequest) throws IOException {
        URI uri;
        HttpEntity entity;
        StringBuilder sb = new StringBuilder();
        sb.append("curl ");
        for (Header header : httpUriRequest.getAllHeaders()) {
            sb.append("--header \"");
            sb.append(header.toString().trim());
            sb.append("\" ");
        }
        URI uri2 = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            HttpRequest original = ((RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = ((HttpUriRequest) original).getURI();
            } else {
                uri = uri2;
            }
        } else {
            uri = uri2;
        }
        sb.append("\"");
        sb.append(uri);
        sb.append("\"");
        if ((httpUriRequest instanceof HttpEntityEnclosingRequest) && (entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity()) != null && entity.isRepeatable()) {
            if (entity.getContentLength() < 1024) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                entity.writeTo(byteArrayOutputStream);
                sb.append(" --data-ascii \"").append(byteArrayOutputStream.toString()).append("\"");
            } else {
                sb.append(" [TOO MUCH DATA TO INCLUDE]");
            }
        }
        return sb.toString();
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) {
        return this.c.execute(httpHost, httpRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        return this.c.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler) {
        return this.c.execute(httpUriRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        return this.c.execute(httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return this.c.execute(httpHost, httpRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.c.execute(httpHost, httpRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest) {
        return this.c.execute(httpUriRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return this.c.execute(httpUriRequest, httpContext);
    }

    protected final void finalize() throws Throwable {
        super.finalize();
        if (this.d != null) {
            Log.e("AndroidHttpClient_v09", "Leak found", this.d);
            this.d = null;
        }
    }

    @Override // org.apache.http.client.HttpClient
    public final ClientConnectionManager getConnectionManager() {
        return this.c.getConnectionManager();
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpParams getParams() {
        return this.c.getParams();
    }
}
