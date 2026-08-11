package defpackage;

import android.content.ContentResolver;
import android.os.Build;
import android.os.SystemClock;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public final class dP implements HttpClient {
    private final dH a;

    public dP(ContentResolver contentResolver, String str, boolean z) {
        this.a = dH.a((str + " (" + Build.DEVICE + " " + Build.ID + ")") + "; gzip");
    }

    private HttpResponse a(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        SystemClock.elapsedRealtime();
        try {
            HttpResponse httpResponseExecute = this.a.execute(httpUriRequest, httpContext);
            Integer.toString(httpResponseExecute.getStatusLine().getStatusCode());
            return httpResponseExecute;
        } catch (IOException e) {
            throw e;
        }
    }

    private static RequestWrapper a(HttpUriRequest httpUriRequest) throws ClientProtocolException {
        try {
            RequestWrapper entityEnclosingRequestWrapper = httpUriRequest instanceof HttpEntityEnclosingRequest ? new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpUriRequest) : new RequestWrapper(httpUriRequest);
            entityEnclosingRequestWrapper.resetHeaders();
            return entityEnclosingRequestWrapper;
        } catch (ProtocolException e) {
            throw new ClientProtocolException(e);
        }
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) {
        return this.a.execute(httpHost, httpRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        return this.a.execute(httpHost, httpRequest, responseHandler, httpContext);
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
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return this.a.execute(httpHost, httpRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.a.execute(httpHost, httpRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest) {
        return execute(httpUriRequest, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws ClientProtocolException {
        String string = httpUriRequest.getURI().toString();
        try {
            URI uri = new URI(string);
            RequestWrapper requestWrapperA = a(httpUriRequest);
            requestWrapperA.setURI(uri);
            return a(requestWrapperA, httpContext);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Bad URL from: " + string, e);
        }
    }

    @Override // org.apache.http.client.HttpClient
    public final ClientConnectionManager getConnectionManager() {
        return this.a.getConnectionManager();
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpParams getParams() {
        return this.a.getParams();
    }
}
