package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.TrafficStats;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.EventLog;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: renamed from: c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0054c implements HttpClient {
    private final AndroidHttpClient a;
    private final ContentResolver b;
    private final String c;
    private final ThreadLocal d = new ThreadLocal();

    public C0054c(Context context, String str, boolean z) {
        SocketFactory c0178f;
        this.a = AndroidHttpClient.newInstance(str + " (" + Build.DEVICE + " " + Build.ID + ")", context);
        this.b = context.getContentResolver();
        this.c = str;
        SchemeRegistry schemeRegistry = getConnectionManager().getSchemeRegistry();
        for (String str2 : schemeRegistry.getSchemeNames()) {
            Scheme schemeUnregister = schemeRegistry.unregister(str2);
            SocketFactory socketFactory = schemeUnregister.getSocketFactory();
            if (socketFactory instanceof LayeredSocketFactory) {
                c0178f = new C0151e(this, (LayeredSocketFactory) socketFactory);
            } else {
                c0178f = new C0178f(this, socketFactory);
            }
            schemeRegistry.register(new Scheme(str2, c0178f, schemeUnregister.getDefaultPort()));
        }
    }

    public final void a() {
        this.a.close();
    }

    private HttpResponse a(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        HttpResponse httpResponseExecute;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            this.d.set(null);
            if (C0223o.a(this.b, "http_stats", false)) {
                int iMyUid = Process.myUid();
                long uidTxBytes = TrafficStats.getUidTxBytes(iMyUid);
                long uidRxBytes = TrafficStats.getUidRxBytes(iMyUid);
                HttpResponse httpResponseExecute2 = this.a.execute(httpUriRequest, httpContext);
                HttpEntity entity = httpResponseExecute2 == null ? null : httpResponseExecute2.getEntity();
                if (entity != null) {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    httpResponseExecute2.setEntity(new C0205g(entity, this.c, iMyUid, uidTxBytes, uidRxBytes, jElapsedRealtime2 - jElapsedRealtime, jElapsedRealtime2));
                }
                httpResponseExecute = httpResponseExecute2;
            } else {
                httpResponseExecute = this.a.execute(httpUriRequest, httpContext);
            }
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            try {
                EventLog.writeEvent(203002, Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), Integer.valueOf(statusCode), this.c, Integer.valueOf((this.d.get() != null || statusCode < 0) ? 0 : 1));
            } catch (Exception e) {
            }
            return httpResponseExecute;
        } finally {
            try {
                EventLog.writeEvent(203002, Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), -1, this.c, Integer.valueOf((this.d.get() != null || -1 < 0) ? 0 : 1));
            } catch (Exception e2) {
                Log.e("GoogleHttpClient", "Error recording stats", e2);
            }
        }
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws ClientProtocolException, C0125d {
        String string = httpUriRequest.getURI().toString();
        C0218j c0218jA = C0217i.a(this.b).a(string);
        String strA = c0218jA.a(string);
        if (strA == null) {
            Log.w("GoogleHttpClient", "Blocked by " + c0218jA.a + ": " + string);
            throw new C0125d(c0218jA);
        }
        if (strA == string) {
            return a(httpUriRequest, httpContext);
        }
        try {
            URI uri = new URI(strA);
            RequestWrapper requestWrapperA = a(httpUriRequest);
            requestWrapperA.setURI(uri);
            return a(requestWrapperA, httpContext);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Bad URL from rule: " + c0218jA.a, e);
        }
    }

    private static RequestWrapper a(HttpUriRequest httpUriRequest) throws ClientProtocolException {
        RequestWrapper requestWrapper;
        try {
            if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
                requestWrapper = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpUriRequest);
            } else {
                requestWrapper = new RequestWrapper(httpUriRequest);
            }
            requestWrapper.resetHeaders();
            return requestWrapper;
        } catch (ProtocolException e) {
            throw new ClientProtocolException(e);
        }
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpParams getParams() {
        return this.a.getParams();
    }

    @Override // org.apache.http.client.HttpClient
    public final ClientConnectionManager getConnectionManager() {
        return this.a.getConnectionManager();
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest) {
        return execute(httpUriRequest, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return this.a.execute(httpHost, httpRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.a.execute(httpHost, httpRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler) {
        return this.a.execute(httpUriRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        return this.a.execute(httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) {
        return this.a.execute(httpHost, httpRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        return this.a.execute(httpHost, httpRequest, responseHandler, httpContext);
    }
}
