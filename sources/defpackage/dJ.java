package defpackage;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
final class dJ extends DefaultHttpClient {
    private /* synthetic */ dH a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    dJ(dH dHVar, ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
        this.a = dHVar;
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    protected final HttpContext createHttpContext() {
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basicHttpContext;
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    protected final BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor basicHttpProcessorCreateHttpProcessor = super.createHttpProcessor();
        basicHttpProcessorCreateHttpProcessor.addRequestInterceptor(dH.b);
        basicHttpProcessorCreateHttpProcessor.addRequestInterceptor(new dK(this.a));
        return basicHttpProcessorCreateHttpProcessor;
    }
}
